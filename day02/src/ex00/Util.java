package ex00;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class Util {

  static private char[] lookUpHexAlphabet = "0123456789ABCDEF".toCharArray();

  static public String encode(byte[] binaryData) {
    if (binaryData == null)
      return null;
    int lengthData   = binaryData.length;
    int lengthEncode = lengthData * 2;
    char[] encodedData = new char[lengthEncode];
    int temp;
    for (int i = 0; i < lengthData; i++) {
      temp = binaryData[i];
      if (temp < 0)
        temp += 256;
      encodedData[i*2] = lookUpHexAlphabet[temp >> 4];
      encodedData[i*2+1] = lookUpHexAlphabet[temp & 0xf];
    }
    return new String(encodedData);
  }

  static public String getBytesFromFile(File file) throws IOException {
    InputStream stream = new FileInputStream(file);
    byte[] bytes = new byte[8];
    stream.read(bytes);
    return Util.encode(bytes);
  }

  static public String getKeyBySignature(Map<String, String> signature, String code) {
    for (String key: signature.keySet()) {
      if (code.indexOf(key) == 0) {
        return key;
      }
    }
    return null;
  }
}
