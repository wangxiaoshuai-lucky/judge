package cn.wzy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class JudgeTask {

  private String appName;

  private int submitId;

  private int compilerId;

  private int problemId;

  private String source;

  private int timeLimit;

  private int memoryLimit;

  private boolean isSpecial;
}
