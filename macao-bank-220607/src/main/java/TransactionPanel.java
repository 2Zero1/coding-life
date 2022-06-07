import javax.swing.*;
import java.awt.*;

public class TransactionPanel extends JPanel {
    Account account;

    public TransactionPanel(Account account) {
        this.setLayout(new GridLayout(1 + account.transactionSize(), 1));
        JLabel title = new JLabel("이력");
        this.add(title);

        for (String transaction: account.transactions()) {
            this.add(new JLabel(transaction));
        }
    }
}
