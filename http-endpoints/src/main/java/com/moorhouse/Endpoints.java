package com.moorhouse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sample")
public class Endpoints {

  @GetMapping
  ResponseEntity<String> getSampleResponse() {
    return new ResponseEntity<>("sample response", HttpStatus.OK);
  }

  @PostMapping(consumes = "application/json", produces = "application/json")
  ResponseEntity<String> postSampleResponse(@RequestBody String requestBody) {
    System.out.println(requestBody);
    return new ResponseEntity<>("sample post body: " + requestBody, HttpStatus.OK);
  }
}
