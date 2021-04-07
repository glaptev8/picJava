package ex03;

public class Program {
  public static void main(String[] args) {
    TransactionsLinkedList transactionsLinkedList = new TransactionsLinkedList();
    User user1 = new User("Johne", 500);
    User user2 = new User("Mike", 500);
    Transaction transaction = new Transaction(user1, user2, 500);
    Transaction transaction2 = new Transaction(user2, user1, 500);
    transactionsLinkedList.add(transaction);
    transactionsLinkedList.add(transaction2);
    transactionsLinkedList.deleteById(transaction2.getIdentifier());
    transactionsLinkedList.deleteById(transaction.getIdentifier());
    for (int i = 0; i < 5; i++) {
      user1 = new User("Johne", 500);
      user2 = new User("Mike", 500);
      transactionsLinkedList.add(new Transaction(user1, user2, 500));
    }
    Transaction[] transactions = transactionsLinkedList.toArray();
    System.out.println(transactions[1].getIdentifier());
    try {
      transactionsLinkedList.deleteById("transactions[1].getIdentifier()");
    } catch (TransactionNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }
}
