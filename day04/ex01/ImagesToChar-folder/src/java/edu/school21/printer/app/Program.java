package edu.school21.printer.app;

import edu.school21.printer.logic.ReaderFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Program {

  private static final String WHITE = "white";
  private static final String BLACK = "black";
//  private static final String PATH = Program.class.getClassLoader().getResource("resources/image.bmp").getPath();

  public static void main(String[] args) throws IOException {
    if (args.length != 2) {
      System.out.println("not valid arguments");
      System.exit(-1);
    }

    Map<String, String> arguments = Arrays
      .stream(args)
      .map(argumnet -> argumnet.split("="))
      .collect(Collectors.toMap(e -> e[0], e -> e[1]));

    String white = arguments.get(WHITE);
    String black = arguments.get(BLACK);
//    String path = PATH;

    char[][] map = ReaderFile.read("path");
    print(map, black, white);
  }

  static public void print(char[][] map, String black, String white) {
    for (char[] column : map) {
      for (char row : column) {
        System.out.print(row == 0 ? black : white);
      }
      System.out.println();
    }
  }
}
