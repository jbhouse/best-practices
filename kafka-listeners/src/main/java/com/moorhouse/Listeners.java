package com.moorhouse;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Listeners {
  private final KafkaTemplate<String,String> kafkaTemplate;
  public Listeners(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @KafkaListener(topics = "sample-input", containerFactory = "kafkaListenerContainerFactory")
  void printSampleMessage(ConsumerRecord<String, String> kafkaRecord) {
    System.out.println("consumed from sample-input: " + kafkaRecord.value());
    kafkaTemplate.sendDefault(kafkaRecord.value());
  }
}
