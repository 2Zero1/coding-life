import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class TodoItemPanel extends JPanel{
  Todo todo;

  public TodoItemPanel(Todo todo, TodoAction todoAction) {
    this.todo = todo;

    this.setLayout(new FlowLayout());

    JCheckBox checkBox = new JCheckBox(todo.getTitle());
    checkBox.setSelected(todo.isCompleted());
    checkBox.addActionListener(e -> {
      todo.toggle();
      todoAction.update();
    });

    this.add(checkBox);

    JButton button = new JButton("x");
    button.addActionListener(e -> {
      todoAction.remove(todo);
    });

    this.add(button);
  }


}
