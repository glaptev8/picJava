package ex00;

public class User {
  private int identifier;
  private String name;
  private int balance;

  public User(int identifier, String name) {
    this.identifier = identifier;
    this.name = name;
  }

  public User(int identifier, String name, int balance) {
    this(identifier, name);
    if (balance < 0) {
      System.err.println("Error. Balance cannot be negative.");
      System.exit(-1);
    }
    this.balance = balance;
  }

  public int getIdentifier() {
    return identifier;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    if (balance < 0) {
      System.err.println("Error. Balance cannot be negative.");
      System.exit(-1);
    }
    this.balance = balance;
  }
}
