public class Todo {
  private String title;
  private boolean isCompleted = false;

  public Todo(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void toggle() {
    this.isCompleted = !this.isCompleted;
  }

  public boolean isCompleted() {
    return isCompleted;
  }
}
