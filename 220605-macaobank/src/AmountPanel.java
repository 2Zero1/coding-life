import javax.swing.*;
import java.awt.*;

public class AmountPanel extends JPanel {
    private Account account;

    public AmountPanel(Account account) {
        this.account = account;

        this.setLayout(new GridLayout(2, 1));

        this.add(new JLabel(this.accountNumber()));
        this.add(new JLabel(this.amount()));
    }

    private String accountNumber() {
        return "계좌 번호: " + this.account.getAccountNumber();
    }

    private String amount() {
        return "잔액: " + this.account.getAmount();
    }
}
