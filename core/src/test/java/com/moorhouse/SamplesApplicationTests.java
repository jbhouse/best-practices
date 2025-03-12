package com.moorhouse;

import com.maciejwalkowiak.wiremock.spring.ConfigureWireMock;
import com.maciejwalkowiak.wiremock.spring.EnableWireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableWireMock({@ConfigureWireMock(name = "sample", port = 8081)})
class SamplesApplicationTests {
	@Autowired private TestRestTemplate testRestTemplate;
	@Test
	void validateGetRequest() {
		ResponseEntity<String> sampleResponse = testRestTemplate.getForEntity("/v1/sample",String.class);
		assertEquals(HttpStatus.OK, sampleResponse.getStatusCode());
		assertEquals("sample response: {\"version\":1,\"message\":\"external get\"}", sampleResponse.getBody());
	}
	@Test
	void validatePostRequest() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);

		String input = "input";
		HttpEntity<String> requestEntity = new HttpEntity<>(input, headers);
		String sampleResponse = testRestTemplate.postForObject("/v1/sample", requestEntity, String.class);

		assertEquals("sample post body: input\n" +
				"sample response body: {\"version\":1,\"message\":\"external post\"}", sampleResponse);
	}
}
