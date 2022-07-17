import java.util.ArrayList;
import java.util.List;

public class Account {
  private final String number;

  private long amount;

  private final List<String> transactions = new ArrayList<>();

  public static void main(String[] args) {
    Account account = new Account("12224-5678", 1000);

    System.out.println("Amout: " + account.getAmount());
    assert account.getAmount() == 1000;

    account.transfer(100);

    System.out.println("Amount: " + account.getAmount());
    assert account.getAmount() == 900;

    account.transfer(50);

    System.out.println("Amount: " + account.getAmount());
    assert account.getAmount() == 850;

    for (String transaction : account.transactions()) {
      System.out.println(transaction);
    }
  }

  public Account(String number, long amount) {
    this.number = number;
    this.amount = amount;
  }

  public String getNumber() {
    return number;
  }

  public long getAmount() {
    return amount;
  }

  public List<String> transactions() {
    return new ArrayList<>(transactions);
  }

  public int transactionsSize() {
    return transactions.size();
  }

  public void transfer(long transferAmount) {
    amount -= transferAmount;

    transactions.add("송금: " + transferAmount + "원");
  }
}