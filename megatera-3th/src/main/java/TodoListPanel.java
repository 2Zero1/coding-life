import java.awt.GridLayout;
import javax.swing.JPanel;

public class TodoListPanel extends JPanel {
  TodoCore todoCore;
  TodoAction todoAction;

  public TodoListPanel(TodoCore todoCore, TodoAction todoAction) {
    this.todoCore = todoCore;
    this.todoAction = todoAction;
  }

  public void update() {
    this.setLayout(new GridLayout(todoCore.size(), 1));

    this.removeAll();

    for (Todo todo : todoCore.todos()) {
      this.add(new TodoItemPanel(todo, todoAction));
    }

    this.updateUI();
  }
}
