import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator {
  private JTextField textField;
  private JPanel panel;

  private CoreCalculator coreCalculator;

  public static void main(String[] args) {
    Calculator application = new Calculator();
    application.run();
  }

  public void run() {
    coreCalculator = new CoreCalculator();

    JFrame frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    textField = new JTextField(10);
    updateDisplay(coreCalculator.getCurrentNumber());
    textField.setEditable(false);
    textField.setHorizontalAlignment(JTextField.RIGHT);
    frame.add(textField, BorderLayout.PAGE_START);

    panel = new JPanel();
    panel.setLayout(new GridLayout(5, 3));
    frame.add(panel);

    initNumberButtons();
    initOperatorButtons();

    frame.pack();
    frame.setVisible(true);
  }

  public void initNumberButtons() {
    for (int i = 0; i < 10; i += 1) {
      String number = Integer.toString((i + 1) % 10);
      JButton button = new JButton(number);
      button.addActionListener(event -> {
        coreCalculator.addNumber(number);
        updateDisplay(coreCalculator.getCurrentNumber());
      });
      panel.add(button);
    }
  }

  public void initOperatorButtons() {
    for (String operator : CoreCalculator.OPERATORS) {
      JButton button = new JButton(operator);
      button.addActionListener(event -> {
        coreCalculator.calculate();
        coreCalculator.updateOperator(operator);
        updateDisplay(coreCalculator.getAccumulator());
      });
      panel.add(button);
    }
  }

  public void updateDisplay(String number) {
    textField.setText(number);
  }
}