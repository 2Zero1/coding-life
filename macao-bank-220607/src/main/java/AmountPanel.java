import javax.swing.*;
import java.awt.*;

public class AmountPanel extends JPanel {

    public AmountPanel(Account account) {
        this.setLayout(new GridLayout(2, 1));
        this.add(new JLabel("잔액 조회"));
        this.add(new JLabel("잔액 조회: " + account.getAmount()));
    }
}
