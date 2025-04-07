package com.moorhouse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController implements SampleApi {
  Logger log = LoggerFactory.getLogger(SampleController.class);
  private final SampleService sampleServiceImpl;
  public SampleController(SampleService sampleServiceImpl) {
    this.sampleServiceImpl = sampleServiceImpl;
  }
  @Override
  public ResponseEntity<String> getSampleResponse() {
    try {
      log.debug("debug msg");
      log.info("getSampleResponse");
      return new ResponseEntity<>(sampleServiceImpl.getSampleResponse(), HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  @Override
  public ResponseEntity<String> postSampleResponse(String body) {
    try {
      log.info("postSampleResponse");
      String sr = sampleServiceImpl.postSampleResponse(body);
      return new ResponseEntity<>(sr, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
