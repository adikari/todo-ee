package au.com.subash.controller;

import au.com.subash.entity.TodoItem;
import au.com.subash.entity.TodoList;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author subash
 */
@Named(value = "navigationBean")
@SessionScoped
public class NavigationBean implements Serializable {

    private List<TodoList> todoLists;
    
    public NavigationBean() {
        todoLists = new ArrayList();
        
        ArrayList<TodoItem> todoItems = new ArrayList();
        todoItems.add(new TodoItem("Work on assignment"));
        todoItems.add(new TodoItem("Call sujan"));
        
        todoLists.add(new TodoList("list 1", todoItems));
        todoLists.add(new TodoList("list 2"));
    }

    public List<TodoList> getTodoLists() {
        return todoLists;
    }

    public void setTodoLists(List<TodoList> todoLists) {
        this.todoLists = todoLists;
    }
    
    public void addTodoList() {
        todoLists.add(new TodoList("Untitled"));
    }
}
