package ex03;

public class Node {
  private Transaction transaction;
  Node next;
  Node prev;

  public Node(Transaction transaction, Node next, Node prev) {
    this.transaction = transaction;
    this.next = next;
    this.prev = prev;
  }

  public Node(Transaction transaction) {
    this.transaction = transaction;
    this.next = this;
    this.prev = this;
  }

  public Transaction getTransaction() {
    return transaction;
  }

  public Node getNext() {
    return next;
  }

  public Node getPrev() {
    return prev;
  }
}
