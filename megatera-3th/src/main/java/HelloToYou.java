import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class HelloToYou {
  private String name = "world";

  public static void main(String[] args) {
    HelloToYou application = new HelloToYou();
    application.run();
  }

  public void run () {
    JFrame frame = new JFrame("Hello, world");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(3, 1));

    JLabel label = new JLabel(greetingMessage());
    frame.add(label);

    JTextField textField = new JTextField(10);
    frame.add(textField);

    JButton button = new JButton("Update");
    button.addActionListener(e -> {
      name = textField.getText();
      label.setText(greetingMessage());
    });
    frame.add(button);

    frame.pack();
    frame.setVisible(true);
  }

  public String greetingMessage() {
    return "Hello, " + name;
  }

}
