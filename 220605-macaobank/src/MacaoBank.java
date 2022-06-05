import javax.swing.*;
import java.awt.*;

public class MacaoBank {
    private JFrame frame;
    private JPanel contentPanel;
    private Account account;

    public static void main(String[] args) {
        MacaoBank macaoBank = new MacaoBank();
        macaoBank.run();
    }

    public void run() {
        account = new Account("123-123-123");

        frame = new JFrame("MacaoBank");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);

        initMenu();
        initContentPanel();

        frame.setVisible(true);
    }

    private void initContentPanel() {
        contentPanel = new JPanel();
        frame.add(contentPanel);
    }

    public void initMenu() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        frame.add(panel, BorderLayout.PAGE_START);

        panel.add(createMenuButton());
        panel.add(createTransferButton());
        panel.add(createTransactionButton());
    }

    private JButton createMenuButton() {
        JButton button = new JButton("잔액 조회");

        button.addActionListener(event -> {
            showContentPanel(new AmountPanel(account));
        });

        return button;
    }

    private void showContentPanel(JPanel panel) {
        contentPanel.removeAll();

        contentPanel.add(panel);

        contentPanel.setVisible(false);
        contentPanel.setVisible(true);

        frame.setVisible(true);
    }

    private JButton createTransferButton() {
        JButton button = new JButton("이체");

        button.addActionListener(event -> {
            showContentPanel(new TransferPanel(account));
        });

        return button;
    }

    private JButton createTransactionButton() {
        JButton button = new JButton("이력");

        button.addActionListener(event -> {
            showContentPanel(new TransactionPanel(account));
        });

        return button;
    }
}
