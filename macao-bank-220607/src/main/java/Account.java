import java.util.ArrayList;
import java.util.List;

public class Account {
    private int amount = 1000;
    private List<String> transactions = new ArrayList<>();

    public int getAmount() {
        return amount;
    }

    public void transfer(int amount) {
        this.amount -= amount;
        transactions.add("입금: "+ amount);
    }

    public List<String> transactions() {
        return new ArrayList<>(transactions);
    }

    public int transactionSize() {
        return transactions.size();
    }
}
