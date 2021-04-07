package ex00;

import java.util.UUID;

public class Transaction {
  private String identifier;
  private User recipient;
  private User sender;
  private TransferType transferType;
  private int transferAmount;

  private enum TransferType {
    DEBITS("INCOME"),
    CREDITS("OUTCOME");

    private String code;

    TransferType(String code) {
      this.code = code;
    }

    public String getCode() {
      return code;
    }
  }

  public Transaction(User recipient, User sender, int transferAmount) {
    this.identifier = UUID.randomUUID().toString();
    this.recipient = recipient;
    this.sender = sender;
    this.transferType = transferAmount >= 0 ? TransferType.DEBITS : TransferType.CREDITS;
    this.transferAmount = transferAmount;
  }

  public User getRecipient() {
    return recipient;
  }

  public void setRecipient(User recipient) {
    this.recipient = recipient;
  }

  public User getSender() {
    return sender;
  }

  public void setSender(User sender) {
    this.sender = sender;
  }

  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public TransferType getTransferType() {
    return transferType;
  }

  public void setTransferType(TransferType transferType) {
    this.transferType = transferType;
  }

  public int getTransferAmount() {
    return transferAmount;
  }

  public void setTransferAmount(int transferAmount) {
    this.transferAmount = transferAmount;
  }

  @Override
  public String toString() {
    return recipient.getName() + " -> " + sender.getName() + ", " + transferAmount + ", transaction " + identifier;
  }
}
