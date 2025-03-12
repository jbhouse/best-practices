package com.moorhouse;

import com.maciejwalkowiak.wiremock.spring.ConfigureWireMock;
import com.maciejwalkowiak.wiremock.spring.EnableWireMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@EnableWireMock({@ConfigureWireMock(name = "sample", port = 8081)})
class SamplesApplicationTests {
	@Autowired
	private SampleServiceImpl sampleService;
	@Test
	void validateGetRequest() {
		String sampleResponse = sampleService.getSampleResponse();
		assertEquals("sample response: {\"version\":1,\"message\":\"external get\"}", sampleResponse);
	}
	@Test
	void validatePostRequest() {
		String input = "input";
		String sampleResponse = sampleService.postSampleResponse(input);
		assertEquals("sample post body: input\n" +
				"sample response body: {\"version\":1,\"message\":\"external post\"}", sampleResponse);
	}
}
