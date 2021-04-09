public class ProducerConsumer {
  private boolean flag = true;

  public synchronized void printEgg() throws InterruptedException {
    while (!flag) {
      wait();
    }
    flag = false;
    System.out.println("Egg");
    notify();
  }

  public synchronized void printHen() throws InterruptedException {
    while (flag) {
      wait();
    }
    flag = true;
    System.out.println("Hen");
    notify();
  }
}
