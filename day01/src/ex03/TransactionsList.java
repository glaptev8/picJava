package ex03;

public interface TransactionsList {
  boolean add(Transaction transaction);

  boolean deleteById(String id);

  Transaction[] toArray();
}
