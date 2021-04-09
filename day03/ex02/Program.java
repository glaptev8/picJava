import java.util.concurrent.ThreadLocalRandom;

public class Program {
  private static long sum = 0;

  public static void main(String[] args) throws InterruptedException {
    final int size = Integer.parseInt(args[0].split("=")[1]);
    int threadCount = Integer.parseInt(args[1].split("=")[1]);
    int[] array = new int[size];
    ThreadGroup threadGroup = new ThreadGroup("math");
    for (int i = 0; i < size; i++) {
      int random = ThreadLocalRandom.current().nextInt(-1000, 1000);
      array[i] = random;
      sum += random;
    }
    System.out.println("Sum: " + sum);
    sum = 0;
    for (int i = 0; i < threadCount; i++) {
      if (i + 1 < threadCount) {
        Math math = new Math(array, size / threadCount * i, size / threadCount * (i + 1), threadGroup, i);
        math.start();
      } else {
        Math math = new Math(array, size / threadCount * i, size, threadGroup, i);
        math.start();
      }
    }
    while (threadGroup.activeCount() != 0) {}
    System.out.println("Sum by threads: " + sum);
  }

  public synchronized static void plus(long num) {
    sum += num;
  }


}
