package ex00;

public class Program {
  final static int SIX_DIGIT_NUMBER = 479598;

  public static void main(String[] args) {
    int sum = SIX_DIGIT_NUMBER % 10
      + (SIX_DIGIT_NUMBER / 10 % 10)
      + (SIX_DIGIT_NUMBER / 100 % 10)
      + (SIX_DIGIT_NUMBER / 1000 % 10)
      + (SIX_DIGIT_NUMBER / 10000 % 10)
      + (SIX_DIGIT_NUMBER / 100000);
    System.out.println(sum);
  }
}
