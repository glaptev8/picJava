public class Egg extends Thread {

  int count;

  public Egg(int count) {
    this.count = count;
  }

  @Override
  public void run() {
    for (int i = 0; i < count; i++) {
      try {
        sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Egg");
    }
  }
}
