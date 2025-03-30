package com.moorhouse;

import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {
  private final ExternalApi externalApi;
  public SampleServiceImpl(ExternalApi externalApi) {
    this.externalApi = externalApi;
  }
  @Override
  public String getSampleResponse() {
    String externalResponse = externalApi.getSampleResponse();
    return "sample response: " + externalResponse;
  }
  @Override
  public String postSampleResponse(String body) {
    String externalResponse = externalApi.postSampleResponse(body);
    return "sample post body: " + body + "\nsample response body: " + externalResponse;
  }
}
