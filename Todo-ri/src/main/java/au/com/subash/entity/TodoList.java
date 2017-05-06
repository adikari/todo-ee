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
    
    public TodoList(String title, List todoItems) {
        this.title = title;
        this.todoitemCollection = todoItems;
    }
   
    public TodoList(String title) {
        this(title, new ArrayList());
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
