import java.util.ArrayList;
import java.util.List;

public class Account {
    private String number;
    private int amount = 50000;
    private List<String> transactions = new ArrayList<>();

    public Account(String number) {
        this.number = number;
    }

    public String getAccountNumber() {
        return this.number;
    }

    public int getAmount() {
        return this.amount;
    }

    public void send(int amount) {
        this.amount -= amount;

        this.transactions.add("이체 금액: " + amount);
    }

    public List<String> transactions() {
        return new ArrayList<>(this.transactions);
    }

    public int transactionSize() {
        return this.transactions.size();
    }
}
