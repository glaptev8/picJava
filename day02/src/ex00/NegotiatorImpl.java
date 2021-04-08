package ex00;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class NegotiatorImpl {

  public static Map<String, String> read(File file) {
    Map<String, String> result = new HashMap<>();
    try {
      int symbol;
      InputStream inputStream = new FileInputStream(file);
      StringBuilder code = new StringBuilder();
      StringBuilder expansion = new StringBuilder();
      boolean flag = true;
      while(true) {
        symbol = inputStream.read();
        if ((char)symbol == '\n' || symbol == -1) {
          flag = true;
          if (code.length() != 0) {
            result.put(code.toString().replaceAll(" ", ""), expansion.toString());
          }
          code = new StringBuilder();
          expansion = new StringBuilder();
          if (symbol == - 1) {
            inputStream.close();
            break;
          }
          continue;
        }
        if ((char)symbol == ',') {
          flag = false;
          continue;
        }
        if (flag) {
          expansion.append((char) symbol);
        }
        if (!flag) {
          code.append((char) symbol);
        }
      }
      inputStream.close();
    } catch (IOException e) {
      System.err.println(e.getMessage() + "\n" + e);
      System.exit(-1);
    }
    return result;
  }

  public static void write(File file, String message) throws IOException {
    FileOutputStream fileOutputStream = new FileOutputStream(file, true);
    fileOutputStream.write(message.getBytes());
    fileOutputStream.close();
  }
}
