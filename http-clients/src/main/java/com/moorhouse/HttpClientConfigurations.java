package com.moorhouse;

import com.ApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class HttpClientConfigurations {
  @Bean
  ExternalApi externalApi() {
    return new ExternalApi(new ApiClient(WebClient.create("localhost:8081")));
  }
}
