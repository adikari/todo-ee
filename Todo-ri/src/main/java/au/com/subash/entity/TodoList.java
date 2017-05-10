package au.com.subash.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author subash
 */
public class TodoList {
    private int id;
    private List<TodoItem> todoitemCollection;
    private String title;

    public TodoList(int id, String title, List<TodoItem> todoItems) {
        this(title, todoItems);
        this.id = id;
    }

    public TodoList(String title, List<TodoItem> todoItems) {
        this.title = title;
        this.todoitemCollection = todoItems;
    }

    public TodoList(String title) {
        this(title, new ArrayList<TodoItem>());
    }

    public List<TodoItem> getTodoitemCollection() {
        return todoitemCollection;
    }

    public int getId() {
        return id;
    }

    public void setTodoitemCollection(List<TodoItem> todoitemCollection) {
        this.todoitemCollection = todoitemCollection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
