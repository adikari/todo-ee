package au.com.subash.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author subash
 */
public class TodoList {
    private List<TodoItem> todoItems;
    private String title;
    
    public TodoList(String title, List todoItems) {
        this.title = title;
        this.todoItems = todoItems;
    }
   
    public TodoList(String title) {
        this(title, new ArrayList());
    }
    
    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
