package ex00;

public class Program {
  public static void main(String[] args) {
    User sender = new User(1, "John", 500);
    User recipient = new User(2, "Mike", 700);

    Transaction transaction = new Transaction(sender, recipient, -500);
    Transaction transaction2 = new Transaction(recipient, sender, 500);

    System.out.println(transaction);
    System.out.println(transaction2);
  }
}
