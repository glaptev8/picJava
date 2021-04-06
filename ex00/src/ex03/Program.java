package ex03;

import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String line;
    int i = 1;
    long result = 0;

    while (i < 19 && !(line = scanner.nextLine()).equals("42")) {
      if (!line.equals("Week " + i)) {
        System.err.println("IllegalArgument");
        System.exit(-1);
      }
      int minTest = 0;
      for (int k = 0; k < 5; k++) {
        int num = scanner.nextInt();
        if (minTest == 0 || num < minTest) {
          minTest = num;
        }
      }
      scanner.nextLine();
      int dec = 0;
      for (int j = 0; j < i - 1; j++) {
        dec *= 10;
        if (dec == 0) {
          dec = 10;
        }
      }
      result = minTest * dec + result;
      if (result == 0) {
        result += minTest;
      }
      i++;
    }
    i = 1;
    while (result != 0) {
      long count = result % 10;
      System.out.print("Week ");
      System.out.print(i);
      System.out.print(" ");
      for (int j = 0; j < count; j++) {
        System.out.print("=");
      }
      System.out.println(">");
      result /= 10;
      i++;
    }
  }
}
