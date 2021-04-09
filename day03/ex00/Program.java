public class Program {
  public static void main(String[] args) throws InterruptedException {
    int count = Integer.parseInt(args[0].split("=")[1]);
    Egg egg = new Egg(count);
    Hen hen = new Hen(count);
    egg.start();
    hen.start();
    egg.join();
    hen.join();
    for (int i = 0; i < count; i++) {
      System.out.println("Human");
    }
  }
}
