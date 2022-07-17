import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TodoList implements TodoAction {
  TodoCore todoCore = new TodoCore();

  TodoListPanel todoListPanel = new TodoListPanel(todoCore, this);

  JTextField textField;

  public static void main(String[] args) {
    TodoList todoList = new TodoList();

    todoList.run();
  }

  public void run() {
    JFrame frame = new JFrame("TodoList");

    frame.setSize(300, 500);
    frame.setLayout(new GridLayout(3, 1));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JLabel label = new JLabel("할 일 목록");

    label.setHorizontalAlignment(JLabel.CENTER);

    frame.add(label);

    initForm(frame);

    frame.add(todoListPanel);

    update();

    frame.setVisible(true);
  }

  public void initForm(JFrame frame) {
    JPanel formPanel = new JPanel(new FlowLayout());

    formPanel.add(new JLabel("할 일: "));

    textField = new JTextField(10);
    formPanel.add(textField);

    JButton button = new JButton("추가");

    button.addActionListener(e -> {
      add(textField.getText());
      update();
    });

    formPanel.add(button);

    frame.add(formPanel);
  }

  @Override
  public void add(String title) {
    todoCore.add(new Todo(title));
    textField.setText("");
    textField.updateUI();
    update();
  }

  @Override
  public void update() {
    todoListPanel.update();
  }

  @Override
  public void remove(Todo todo) {
    todoCore.remove(todo);
    update();
  }
}
