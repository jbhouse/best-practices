package com.moorhouse.services;

import com.moorhouse.ExternalApi;
import com.moorhouse.SampleApiDelegate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SampleService implements SampleApiDelegate {
  private final ExternalApi externalApi;
  public SampleService(ExternalApi externalApi) {
    this.externalApi = externalApi;
  }
  @Override
  public ResponseEntity<String> getSampleResponse() {
    try {
      System.out.println("getSampleResponse");
      return new ResponseEntity<>(externalApi.getSampleResponse(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  @Override
  public ResponseEntity<String> postSampleResponse(String body) {
    try {
      System.out.println("postSampleResponse");
      String sr = externalApi.postSampleResponse(body);
      return new ResponseEntity<>(sr, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
