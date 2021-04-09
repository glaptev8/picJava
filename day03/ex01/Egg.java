public class Egg extends Thread {
  private ProducerConsumer producerConsumer;
  private int count;

  public Egg(ProducerConsumer producerConsumer, int count) {
    this.producerConsumer = producerConsumer;
    this.count = count;
  }

  @Override
  public void run() {
    for (int i = 0; i < count; i++) {
      try {
        producerConsumer.printEgg();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
