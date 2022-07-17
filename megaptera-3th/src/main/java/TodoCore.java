import java.util.ArrayList;

public class TodoCore {
  ArrayList<Todo> todoList = new ArrayList();

  public void add(Todo todo) {
    todoList.add(todo);
  }

  public void remove(Todo todo) {
    todoList.remove(todo);
  }

  public int size() {
    return todoList.size();
  }

  public ArrayList<Todo> todos() {
    return this.todoList;
  }
}
