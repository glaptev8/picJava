public class Program {
  public static void main(String[] args) {
    ProducerConsumer producerConsumer = new ProducerConsumer();
    int count = Integer.parseInt(args[0].split("=")[1]);
    Egg egg = new Egg(producerConsumer, count);
    Hen hen = new Hen(producerConsumer, count);
    hen.start();
    egg.start();
  }
}
