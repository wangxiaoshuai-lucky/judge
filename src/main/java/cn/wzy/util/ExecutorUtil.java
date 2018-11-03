package cn.wzy.util;

import cn.wzy.vo.ExecMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExecutorUtil {


  public static ExecMessage exec(String cmd) {
    Runtime runtime = Runtime.getRuntime();
    Process exec = null;
    try {
      exec = runtime.exec(cmd);
    } catch (IOException e) {
      e.printStackTrace();
      return new ExecMessage(e.getMessage(), null);
    }
    ExecMessage res = new ExecMessage();
    res.setError(message(exec.getErrorStream()));
    res.setStdout(message(exec.getInputStream()));
    return res;
  }

  private static String message(InputStream inputStream) {
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
      StringBuilder message = new StringBuilder();
      String str;
      while ((str = reader.readLine()) != null) {
        message.append(str);
      }
      String result = message.toString();
      if (result.equals("")) {
        return null;
      }
      return result;
    } catch (IOException e) {
      return e.getMessage();
    } finally {
      try {
        inputStream.close();
        reader.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
