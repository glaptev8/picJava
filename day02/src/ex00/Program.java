package ex00;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;

public class Program {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static File file;
  private static URL signatureUrl = Program.class.getClassLoader().getResource("ex00/signatures.txt");
  private static String path = "/Users/a18445512/Desktop/screen.png";

  public static void main(String[] args) throws IOException {
    if (signatureUrl == null) {
      System.err.println("file not found");
      System.exit(-1);
    }
    file = new File(signatureUrl.toString().substring(5));
    Map<String, String> signature = NegotiatorImpl.read(file);
    String line;
    while (!(line = br.readLine()).equals("42")) {
      String code = Util.getBytesFromFile(new File(line));
      String key;
      if ((key = Util.getKeyBySignature(signature, code)) != null) {
        System.out.println("PROCESSED");
        NegotiatorImpl.write(new File("./result.txt"), signature.get(key) + "\n");
      }
      else {
        System.out.println("UNDEFINED");
      }
    }
  }

}
