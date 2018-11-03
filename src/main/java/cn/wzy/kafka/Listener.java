package cn.wzy.kafka;

import lombok.extern.log4j.Log4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;

@Log4j
public class Listener implements ProducerListener<String, String> {

  public void onSuccess(String topic, Integer partition, Long key, String value, RecordMetadata recordMetadata) {
    log.error("====send success====topic " + value);
  }

  @Override
  public void onError(ProducerRecord<String, String> producerRecord, Exception exception) {
    log.error(exception);
  }
}
