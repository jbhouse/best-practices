package com.moorhouse;

import java.time.Duration;

public class SampleServiceImpl implements SampleService {
  private final ExternalApi externalApi;

  public SampleServiceImpl(ExternalApi externalApi) {
    this.externalApi = externalApi;
  }
  @Override
  public String getSampleResponse() {
    String externalResponse = externalApi.getSampleResponse().block(Duration.ofMillis(5000));
    return "sample response " + externalResponse;
  }
  @Override
  public String postSampleResponse(String body) {
    String externalResponse = externalApi.postSampleResponse(body).block(Duration.ofMillis(5000));
    return "sample post body: " + body + "sample response body: " + externalResponse;
  }
}
