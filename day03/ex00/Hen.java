public class Hen extends Thread {

  int count;

  public Hen(int count) {
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
      System.out.println("Hen");
    }
  }
}
