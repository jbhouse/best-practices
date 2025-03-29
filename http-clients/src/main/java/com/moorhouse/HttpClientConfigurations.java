package com.moorhouse;

import com.ApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class HttpClientConfigurations {
  @Bean
  ExternalApi externalApi() {
    ApiClient apiClient = new ApiClient(RestClient.create());
    apiClient.setBasePath("http://localhost:8081");
    return new ExternalApi(apiClient);
  }
  @Bean
  ExternalCarApi carApi() {
    ApiClient apiClient = new ApiClient(RestClient.create());
    apiClient.setBasePath("http://localhost:8081");
    return new ExternalCarApi(apiClient);
  }
}
