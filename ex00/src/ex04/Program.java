package ex04;

import java.util.Scanner;

public class Program {
  private static int[][] chars = new int[1000][2];
  private static int[][] result = new int[10][2];
  private static int whitespaces;
  private static char DIAGRAM_CHAR = '#';

  static {
    for (int[] aChar : chars) {
      aChar[0] = 65536;
      aChar[1] = 0;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String line = scanner.nextLine();
    scanner.close();
    if (line == null || line.equals("")) {
      return;
    }
    for (char ch : line.toCharArray()) {
      add(ch);
    }
    getTenBiggestNumber();
    sortArray();
    print(createPrint());
  }

  private static void print(int[][] map) {
    if (map == null) return;
    int begin = 1;
    while (map[0][begin] == 0) {
      begin++;
    }
    begin = begin == 1 ? 1 : begin - 1;
    for (int i = begin; i < 11; i++) {
      for (int j = 0; j < 10; j++) {
        if ((i == 10 && map[j][i] == 0 && map[j][0] != 0) || (i == begin && j == 0) || (i != 10 && map[j][i] == 0 && map[j][i + 1] != 0)) {
          printWhitespaces(whitespaces - getCountDigit(map[j][0]) + 1);
          System.out.print(map[j][0]);
          if (i != 10 && !(map[j][i] == 0 && map[j][i + 1] != 0))
            System.out.println();
        }
        if (map[j][i] != 0) {
          printWhitespaces(whitespaces);
          System.out.print(DIAGRAM_CHAR);
        }
      }
      System.out.println();
    }
    for (int[] symb : result) {
      printWhitespaces(whitespaces);
      if (symb[0] != 0 && symb[1] != 0) {
        System.out.print((char) symb[0]);
      }
    }
    System.out.println();
  }

  private static int[][] createPrint() {
    int[][] print = new int[10][11];
    double k;
    if (result[0][1] > 10) {
      k = (double) result[0][1] / 10;
    } else {
      k = 1;
    }
    whitespaces = getCountDigit(result[0][1]);
    for (int i = 0; i < 10; i++) {
      print[i][0] = result[i][1];
      for (int j = 11 - (int) (print[i][0] / k); j < 11; j++) {
        print[i][j] = '3';
      }
    }
    return print;
  }

  private static void printWhitespaces(int count) {
    for (int i = 0; i < count; i++) {
      System.out.print(" ");
    }
  }

  private static int getCountDigit(int number) {
    int count = 0;
    while (number > 0) {
      count++;
      number /= 10;
    }
    return count;
  }

  private static void sortArray() {
    for (int i = 0; i < 10; i++) {
      int maxCount = result[i][1];
      int maxCh = result[i][0];
      int maxI = i;
      for (int j = i + 1; j < 10; j++) {
        if (result[j][1] > maxCount || (result[j][1] == maxCount && result[j][0] < maxCh)) {
          maxI = j;
          maxCount = result[j][1];
          maxCh = result[j][0];
        }
      }
      if (maxI != i) {
        int tmpCount = result[i][1];
        int tmpCh = result[i][0];
        result[i][0] = result[maxI][0];
        result[i][1] = result[maxI][1];
        result[maxI][0] = tmpCh;
        result[maxI][1] = tmpCount;
      }
    }
  }

  private static void getTenBiggestNumber() {
    for (int i = 0; i < 999 || chars[i][0] != 65536; i++) {
      int count = chars[i][1];
      int min = result[0][1];
      int k = 0;
      for (int j = 1; j < 10; j++) {
        if (result[j][1] < min) {
          k = j;
          min = result[j][1];
        }
      }
      if (result[k][1] < count) {
        result[k] = chars[i];
      } else if (result[k][1] == count && result[k][0] > chars[i][0]) {
        result[k] = chars[i];
      }
    }
  }

  public static void add(char ch) {
    int j = 0;
    for (; j < 1000; j++) {
      if (chars[j][0] == ch) {
        chars[j][1]++;
        return;
      } else if (chars[j][0] == 65536) {
        chars[j][0] = ch;
        chars[j][1] = 1;
        return;
      }
    }

  }
}
