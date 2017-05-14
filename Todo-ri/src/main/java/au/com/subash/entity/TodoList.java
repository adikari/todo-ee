package au.com.subash.entity;

/**
 *
 * @author subash
 */
public class TodoList {
  private int id;
  private String title;

  public TodoList() { }

  public TodoList(String title) {
    this.title = title;
  }

  public TodoList(int id, String title) {
    this(title);
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
