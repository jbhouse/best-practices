package com.moorhouse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController implements SampleApi {
  private final SampleService sampleServiceImpl;
  public SampleController(SampleService sampleServiceImpl) {
    this.sampleServiceImpl = sampleServiceImpl;
  }
  @Override
  public ResponseEntity<String> getSampleResponse() {
    try {
      System.out.println("getSampleResponse");
      return new ResponseEntity<>(sampleServiceImpl.getSampleResponse(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  @Override
  public ResponseEntity<String> postSampleResponse(String body) {
    try {
      System.out.println("postSampleResponse");
      String sr = sampleServiceImpl.postSampleResponse(body);
      return new ResponseEntity<>(sr, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
