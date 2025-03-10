package com.moorhouse;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoints implements SampleApi {
  private final SampleService sampleService;
  public Endpoints(SampleService sampleService) {
    this.sampleService = sampleService;
  }
  @Override
  public ResponseEntity<String> getSampleResponse() {
    try {
      System.out.println("getSampleResponse");
      return new ResponseEntity<>(sampleService.getSampleResponse(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  @Override
  public ResponseEntity<String> postSampleResponse(String body) {
    try {
      System.out.println("postSampleResponse");
      String sr = sampleService.postSampleResponse(body);
      return new ResponseEntity<>(sr, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
