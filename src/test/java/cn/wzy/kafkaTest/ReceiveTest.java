package cn.wzy.kafkaTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class ReceiveTest {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @Test
  public void test() {
    while (true) {
    }
  }
}
