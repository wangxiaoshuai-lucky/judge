package cn.wzy.kafka;

import cn.wzy.vo.JudgeResult;
import cn.wzy.vo.JudgeTask;
import com.alibaba.fastjson.JSON;
import lombok.extern.log4j.Log4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.MessageListener;

import java.util.concurrent.*;

@Log4j
public class JudgeConsumer implements MessageListener<String, String> {

  @Autowired
  private KafkaTemplate<String,String> kafkaTemplate;

  public static ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5,
    0L, TimeUnit.MILLISECONDS,
    new LinkedBlockingQueue<>(1));
  public void onMessage(ConsumerRecord<String, String> record) {
    log.info("==JudgeConsumer received:" + record.value());
    Runnable task = new Runnable() {
      @Override
      public void run() {
        JudgeTask judgeTask = JSON.parseObject(record.value(), JudgeTask.class);
        JudgeResult result = Judge.judge(judgeTask);
        kafkaTemplate.sendDefault(JSON.toJSONString(result));
      }
    };
    boolean faild = true;
    while (faild) {
      try {
        executor.execute(task);
        faild = false;
      } catch (RejectedExecutionException e) {
        try {
          Thread.sleep(500);
        } catch (InterruptedException e1) {
          e1.printStackTrace();
        }
      }
    }
  }

}
