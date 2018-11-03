package cn.wzy.kafkaTest;

import cn.wzy.kafka.Judge;
import cn.wzy.vo.JudgeTask;
import cn.wzy.vo.Stdout;
import com.alibaba.fastjson.JSON;

import java.io.*;

public class Main {
  /**
   * 'Accepted',
   * 'Presentation Error',
   * 'Time Limit Exceeded',
   * 'Memory Limit Exceeded',
   * 'Wrong Answer',
   * 'Runtime Error',
   * 'Output Limit Exceeded',
   * 'Compile Error',
   * 'System Error'
   *
   * @param args
   */
  public static void main(String[] args) throws Exception {
//    JudgeTask task = new JudgeTask("asdf", 1, 1, 1, "#include <stdio.h>\n" +
//      "int main() {\n" +
//      "    int a, b;\n" +
//      "    scanf(\"%d %d\", &a, &b);\n" +
//      "    printf(\"%d\\n\", a + b);\n" +
//      "    \n" +
//      "    return 0;\n" +
//      "}", 1000, 65535, false);
//    System.out.println(Judge.judge(task));

//    File file = new File("C:\\Users\\Administrator\\Desktop\\demo\\tmp\\1\\main.c");
//    file.createNewFile();
//    OutputStream output = new FileOutputStream(file);
//    PrintWriter writer = new PrintWriter(output);
//    writer.print("#include <stdio.h>\n" +
//      "int main() {\n" +
//      "    int a, b;\n" +
//      "    scanf(\"%d %d\", &a, &b);\n" +
//      "    printf(\"%d\\n\", a + b);\n" +
//      "    \n" +
//      "    return 0;\n" +
//      "}");
//    writer.close();
//    output.close();

    String json = "{'status': 1, 'max_memory': 0, 'max_used': 0}";
    System.out.println(JSON.parseObject(json,Stdout.class));
  }


}
