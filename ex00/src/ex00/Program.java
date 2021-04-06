package ex00;

public class Program {
    public static void main(String[] args) {
        final int sixDigitNumber = 400102;
        int sum;
        sum = sixDigitNumber % 10 + (sixDigitNumber / 10 % 10) + (sixDigitNumber / 100 % 10) + (sixDigitNumber / 1000 % 10) + (sixDigitNumber / 10000 % 10) + (sixDigitNumber / 100000);
        System.out.println(sum);
    }
}
