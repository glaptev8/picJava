package ex01;

import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();
    if (number < 2) {
      System.err.print("IllegalArgument");
      scanner.close();
      System.exit(-1);
    }
    if (number == 2) {
      System.out.print(true);
      System.out.print(' ');
      System.out.println(1);
      scanner.close();
      return;
    }
    int i = 2;
    for (; i * i <= number; i++) {
      if (number % i == 0) {
        System.out.print(false);
        System.out.print(' ');
        System.out.println(i - 1);
        scanner.close();
        return;
      }
    }
    System.out.print(true);
    System.out.print(' ');
    System.out.println(i - 1);
    scanner.close();
  }
}
