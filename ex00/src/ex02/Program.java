package ex02;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a;
        int count = 0;
        while ((a = scanner.nextInt()) != 42) {
            int sum = 0;
            boolean flag = true;
            while (a != 0) {
                sum += a % 10;
                a /= 10;
            }
            if (sum != 2 && sum != 3 && (sum % 2 == 0 || sum % 3 == 0)) {
                flag = false;
            }
            else {
                for (int i = 5; i * i <= sum; i++) {
                    if (sum % i == 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                count++;
            }
        }
        scanner.close();
        System.out.println("Count of coffee-request - " + count);
    }
}
