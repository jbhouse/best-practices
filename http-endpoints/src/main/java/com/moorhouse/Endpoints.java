package com.moorhouse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Endpoints implements SampleApi {
  @Override
  public ResponseEntity<String> getSampleResponse() {
    return new ResponseEntity<>("sample response", HttpStatus.OK);
  }
  @Override
  public ResponseEntity<String> postSampleResponse(String body) {
    return new ResponseEntity<>("sample post body: " + body, HttpStatus.OK);
  }
}
