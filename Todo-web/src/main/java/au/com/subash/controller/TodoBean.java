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
@Named(value = "todoBean")
@SessionScoped
public class TodoBean implements Serializable {

    private List<TodoList> todoLists;
    private List<TodoItem> todoItems;
    private TodoList selectedList;
    
    public TodoBean() {
        todoLists = new ArrayList();
        
        ArrayList<TodoItem> todoItems = new ArrayList();
        todoItems.add(new TodoItem("Work on assignment"));
        todoItems.add(new TodoItem("Call sujan"));
        
        todoLists.add(new TodoList("list 1", todoItems));
        todoLists.add(new TodoList("list 2"));
        
        selectTodoList(todoLists.get(0));
    }

    public List<TodoList> getTodoLists() {
        return todoLists;
    }

    public void setTodoLists(List<TodoList> todoLists) {
        this.todoLists = todoLists;
    }

    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    public TodoList getSelectedList() {
        return selectedList;
    }

    public void setSelectedList(TodoList selectedList) {
        this.selectedList = selectedList;
    }
    
    /**
     * Add new todo list
     */
    public void addTodoList() {
        todoLists.add(new TodoList("Untitled"));
    }
    
    public void selectTodoList(TodoList list) {
        TodoList todoList = todoLists.stream()
                .filter(l -> l.getTitle().equals(list.getTitle()))
                .findFirst()
                .get();
        
        selectedList = todoList;
        todoItems = selectedList.getTodoItems();
    }
}
