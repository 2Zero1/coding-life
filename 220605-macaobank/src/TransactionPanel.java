import javax.swing.*;
import java.awt.*;

public class TransactionPanel extends JPanel {
    public TransactionPanel(Account account) {
        this.setLayout(new GridLayout(1 + account.transactionSize(), 1));

        JLabel label = new JLabel("이력");
        this.add(label);

        for (String transaction : account.transactions()) {
            this.add(new JLabel(transaction));
        }
    }
}
