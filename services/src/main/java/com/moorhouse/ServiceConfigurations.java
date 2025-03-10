package com.moorhouse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfigurations {
  @Bean
  SampleService sampleService(ExternalApi externalApi) {
    return new SampleServiceImpl(externalApi);
  }
}
