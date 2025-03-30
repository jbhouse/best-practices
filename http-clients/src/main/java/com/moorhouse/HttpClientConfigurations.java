package com.moorhouse;

import com.ApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class HttpClientConfigurations {
  @Value("${external.api.baseurl}")
  private String externalBaseUrl;
  @Value("${cars.api.baseurl}")
  private String carBaseUrl;
  @Bean
  ExternalApi externalApi() {
    ApiClient apiClient = new ApiClient(RestClient.create());
    apiClient.setBasePath(externalBaseUrl);
    return new ExternalApi(apiClient);
  }
  @Bean
  ExternalCarApi carApi() {
    ApiClient apiClient = new ApiClient(RestClient.create());
    apiClient.setBasePath(carBaseUrl);
    return new ExternalCarApi(apiClient);
  }
}
