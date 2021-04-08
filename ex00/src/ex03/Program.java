package ex03;

import java.util.Scanner;


//Week 1
//5 6 7 8 9
//Week 2
//5 6 7 8 9
//Week 3
//5 6 7 8 9
//Week 4
//5 6 7 8 9
//Week 5
//5 6 7 8 9
//Week 6
//5 6 7 8 9
//Week 7
//5 6 7 8 9
//Week 8
//5 6 7 8 9
//Week 9
//5 6 7 8 9
//Week 10
//5 6 7 8 9
public class Program {
  public static void main(String[] args) {
    int[] q = new int[5];
    q[0] = 2;
    q[1] = 2;
    q[2] = 2;
    q[3] = 2;
    q[4] = 2;
    qq(q);
    System.out.println(q[2]);
  }

  public static void qq(int[] q) {
    q[2] = 3;
  }
}
