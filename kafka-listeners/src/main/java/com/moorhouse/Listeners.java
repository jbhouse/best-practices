package com.moorhouse;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Listeners {
  Logger log = LoggerFactory.getLogger(Listeners.class);
  private final KafkaTemplate<String,String> kafkaTemplate;
  public Listeners(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }
  @KafkaListener(topics = "${kafka.sample.input.topic:sample-input}", containerFactory = "kafkaListenerContainerFactory")
  void printSampleMessage(ConsumerRecord<String, String> kafkaRecord) {

    log.info("consumed from sample-input: " + kafkaRecord.value());
    kafkaTemplate.sendDefault(kafkaRecord.value() + " to the sample output topic");
  }
}
