package ex01;

public class User {
  private int identifier;
  private String name;
  private int balance;

  public User(String name) {
    this.identifier = UserIdsGenerator.getInstance().generateId();
    this.name = name;
  }

  public User(String name, int balance) {
    this(name);
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
