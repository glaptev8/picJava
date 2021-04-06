package ex01;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number < 2) {
            System.err.print("IllegalArgument");
            scanner.close();
            return;
        }
        if (number == 2 || number == 3) {
            System.out.print(true);
            System.out.print(' ');
            System.out.print(1);
            scanner.close();
            return;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            System.out.print(false);
            System.out.print(' ');
            System.out.print(1);
            scanner.close();
            return;
        }
        int i = 5;
        for (; i * i <= number; i++) {
            if (number % i == 0) {
                System.out.print(false);
                System.out.print(' ');
                System.out.print(i - 1);
                scanner.close();
                return;
            }
        }
        System.out.print(true);
        System.out.print(' ');
        System.out.print(i - 1);
        scanner.close();
    }
}
