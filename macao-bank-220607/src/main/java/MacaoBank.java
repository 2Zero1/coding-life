import javax.swing.*;
import java.awt.*;

public class MacaoBank {
    private Account account;
    private JFrame frame;
    private JPanel contentPanel;

    public static void main(String[] args) {
        MacaoBank macaoBank = new MacaoBank();
        macaoBank.run();
    }

    private void run() {
        account = new Account();

        frame = new JFrame("MacaoBank");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500, 600);

        initMenuPanel(frame);
        initContentPanel();

        frame.setVisible(true);

    }

    private void initMenuPanel(JFrame frame) {
        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.PAGE_START);

        panel.add(createAmountPanel());
        panel.add(createTransferPanel());
        panel.add(createTransactionPanel());
    }

    private void initContentPanel() {
        contentPanel = new JPanel();
        frame.add(contentPanel);

        contentPanel.add(new AmountPanel(account));
    }

    private JButton createAmountPanel() {
        JButton button = new JButton("잔액 조회");

        button.addActionListener(event -> {
            showContents(new AmountPanel(account));
        });

        return button;
    }

    private JButton createTransferPanel() {
        JButton button = new JButton("이체");

        button.addActionListener(event -> {
            showContents(new TransferPanel(account));
        });

        return button;
    }

    private JButton createTransactionPanel() {
        JButton button = new JButton("이력");

        button.addActionListener(event -> {
            showContents(new TransactionPanel(account));
        });

        return button;
    }

    private void showContents(JPanel panel) {
        contentPanel.removeAll();
        contentPanel.add(panel);

        contentPanel.setVisible(false);
        contentPanel.setVisible(true);

        frame.setVisible(true);
    }
}
