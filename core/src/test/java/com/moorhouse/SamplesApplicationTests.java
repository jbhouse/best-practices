package com.moorhouse;

import com.maciejwalkowiak.wiremock.spring.ConfigureWireMock;
import com.maciejwalkowiak.wiremock.spring.EnableWireMock;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DirtiesContext
@EmbeddedKafka(partitions = 1)
@EnableWireMock({@ConfigureWireMock(name = "sample", port = 8081)})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SamplesApplicationTests {
//	@Autowired private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;
	@Autowired private TestRestTemplate testRestTemplate;
	@Autowired private EmbeddedKafkaBroker embeddedKafkaBroker;
	@Autowired private KafkaTemplate<String, String> kafkaTemplate;
	@Value("${kafka.sample.input.topic:sample-input}")
	private String inputTopic;
	@Value("${kafka.sample.output.topic:sample-output}")
	private String outputTopic;
//	@BeforeEach
//	void setup() {
//		for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry.getListenerContainers()) {
//			ContainerTestUtils.waitForAssignment(messageListenerContainer, 1);
//		}
//	}

	@Test
	void validateGetRequest() {
		ResponseEntity<String> sampleResponse = testRestTemplate.getForEntity("/v1/sample",String.class);
		assertEquals(HttpStatus.OK, sampleResponse.getStatusCode());
		assertEquals("sample response: {\"version\":1,\"message\":\"external get\"}", sampleResponse.getBody());
	}
	@Test
	void validatePostRequest() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(List.of(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);

		String input = "input";
		HttpEntity<String> requestEntity = new HttpEntity<>(input, headers);
		String sampleResponse = testRestTemplate.postForObject("/v1/sample", requestEntity, String.class);

		assertEquals("sample post body: input\n" +
				"sample response body: {\"version\":1,\"message\":\"external post\"}", sampleResponse);
	}
	@Test
	void validateKafkaConsumer() {
		String data = "Sending with our own simple KafkaProducer";

		kafkaTemplate.send(inputTopic, data);
		ConsumerRecord<String, String> consumerRecord = KafkaTestUtils.getSingleRecord(configureConsumer(), outputTopic, Duration.ofSeconds(5));
		assertNotNull(consumerRecord);
		assertNotNull(consumerRecord.value());
		assertEquals(data + " to the sample output topic", consumerRecord.value());
	}

	private Consumer<String, String> configureConsumer() {
		Map<String, Object> consumerProps = KafkaTestUtils.consumerProps("testGroup", "true", embeddedKafkaBroker);
		consumerProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		Consumer<String, String> consumer = new DefaultKafkaConsumerFactory<String, String>(consumerProps).createConsumer();
		consumer.subscribe(Collections.singleton(outputTopic));
		return consumer;
	}
}
