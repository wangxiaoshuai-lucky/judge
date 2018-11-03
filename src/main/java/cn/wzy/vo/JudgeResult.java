package cn.wzy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JudgeResult {

  private Integer submitId;
  private Integer status;
  private Integer timeUsed;
  private Integer memoryUsed;
  private String errorMessage;

}
