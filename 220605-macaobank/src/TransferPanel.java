import javax.swing.*;

public class TransferPanel extends JPanel {
    public TransferPanel(Account account) {
        JLabel label = new JLabel("이체");
        this.add(label);

        JTextField textField = new JTextField(10);
        this.add(textField);

        JButton button = new JButton("확인");
        button.addActionListener(event -> {
            account.send(Integer.valueOf(textField.getText()));
        });
        this.add(button);
    }
}
