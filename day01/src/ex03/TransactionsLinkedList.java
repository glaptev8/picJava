package ex03;

public class TransactionsLinkedList implements TransactionsList {

  Node head;

  @Override
  public boolean add(Transaction transaction) {
    if (head == null) {
      head = new Node(transaction);
    }
    else {
      Node current = head.prev;
      if (current == head) {
        current.next = new Node(transaction, head, head);
      } else {
        current.next = new Node(transaction, head, current);
      }
      head.prev = current.next;
    }
    return true;
  }

  @Override
  public boolean deleteById(String id) {
    if (head == null) {
      return true;
    }
    Node current = head;
    if (current == current.next) {
      if (current.getTransaction().getIdentifier().equals(id)) {
        head = null;
        return true;
      }
    }
    for (;current.next != head ; current = current.next) {
      if (current.getTransaction().getIdentifier().equals(id)) {
        current.prev.next = current.next;
        current.next.prev = current.prev;
        return true;
      }
    }
    if (current.getTransaction().getIdentifier().equals(id)) {
      current.next.prev = current.prev;
      current.prev.next = current.next;
      return true;
    }
    throw new TransactionNotFoundException("not found tranzaction by id = " + id);
  }

  @Override
  public Transaction[] toArray() {
    Node current = head;
    if (head == null) {
      return null;
    }
    int count = 1;
    for (; current.next != head ; current = current.next) {
      count++;
    }
    Transaction[] transactions = new Transaction[count];
    current = head;
    for (int i = 0; i < count; i++) {
      transactions[i] = current.getTransaction();
      current = current.next;
    }
    return transactions;
  }
}
