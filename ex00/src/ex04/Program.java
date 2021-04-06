package ex04;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.Scanner;

public class Program {
    private static int[][] chars = new int[1000][2];
    private static int[][] result = new int[10][2];
    private static int[][] resultSort = new int[10][2];
    private String example = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAASSSSSSSSSSSSSSSSSSSSSSSSDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDWEWWKFKKDKKDSKAKLSLDKSKALLLLLLLLLLRTRTETWTWWWWWWWWWWOOOOOOO42";
    static {
        for (int[] aChar : chars) {
            aChar[0] = 65536;
            aChar[1] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            add(ch);
        }
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
            }
            else if (result[k][1] == count && result[k][0] > chars[i][0]) {
                result[k] = chars[i];
            }
        }
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
        int print[][] = new int[10][11];
        double k = (double)result[0][1] / 10;
        for (int i = 0; i < 10; i++) {
            print[i][0] = result[i][1];

            for (int j = 11 - (int) (print[i][0] / k); j < 11; j++) {
                print[i][j] = '3';
            }
        }
        if (print[0][0] != 0) {
            System.out.println(print[0][0]);
        }
        int count = 0;
        int l = print[0][0];
        while (l > 10) {
            count++;
            l /= 10;
        }
        String whitespace = count == 0 ? "" : count == 1 ? " " : count == 2 ? "  " : null;
        for (int i = 1; i < 11; i++) {
            boolean flag = true;
            int q = 0;
            for (int j = 0; j < 10; j++) {
                if (print[j][0] == 0) {
                    break;
                }
                if (i == 10 && print[j][i] == 0) {
                    System.out.print(whitespace);
                    System.out.print(print[j][0]);
                }
                if (print[j][i] == 0 && i != 10 && print[j][i + 1] != 0) {
                    System.out.print(whitespace);
                    System.out.print(print[j][0]);
                    if (print[j][0] < 10)
                        System.out.print(" ");
                }
                if (print[j][i] != 0) {
                    {
                        System.out.print(whitespace);
                        System.out.print("# ");
                    }
                }
            }
            System.out.println();
        }
        boolean flag = false;
        for (int[] r : result) {
            System.out.print(whitespace);
            if (flag) {
                System.out.print(" ");
            }
            flag = true;
            System.out.print((char) r[0]);
        }
        System.out.println();
    }

    public static void add(char ch) {
        int j = 0;
        for (; j < 1000; j++) {
            if (chars[j][0] == ch) {
                chars[j][1]++;
                return;
            }
            else if (chars[j][0] == 65536) {
                chars[j][0] = ch;
                chars[j][1] = 1;
                return;
            }
        }

    }
}
