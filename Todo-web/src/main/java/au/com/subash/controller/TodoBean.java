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
    private TodoList selectedList;
    private String newTodoItem;

    public String getNewTodoItem() {
        return newTodoItem;
    }

    public void setNewTodoItem(String newTodoItem) {
        this.newTodoItem = newTodoItem;
    }
    
    public TodoBean() {
        todoLists = new ArrayList();
        
        ArrayList<TodoItem> todoItems1 = new ArrayList();
        todoItems1.add(new TodoItem("Work on assignment"));
        todoItems1.add(new TodoItem("Call sujan"));
        
                
        ArrayList<TodoItem> todoItems2 = new ArrayList();
        todoItems2.add(new TodoItem("Make some breakfast"));
        todoItems2.add(new TodoItem("Go to Caufield"));
        
        todoLists.add(new TodoList("list 1", todoItems1));
        todoLists.add(new TodoList("list 2", todoItems2));
        
        selectedList = todoLists.get(0);
    }

    public List<TodoList> getTodoLists() {
        return todoLists;
    }

    public void setTodoLists(List<TodoList> todoLists) {
        this.todoLists = todoLists;
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
        selectedList = new TodoList("Untitled");
        todoLists.add(selectedList);
    }
    
    public void selectTodoList(TodoList list) {
        selectedList = todoLists.stream()
                .filter(l -> l.getTitle().equals(list.getTitle()))
                .findFirst()
                .get();  
    }
    
    public void addTodoItem() {
        if (null == newTodoItem || newTodoItem.isEmpty()) { 
            return; 
        }
        
        selectedList.getTodoItems().add(new TodoItem(newTodoItem));
        setNewTodoItem(null);
    } 
    
    public void deleteTodoList() {
        todoLists.remove(selectedList);
        
        if (todoLists.size() > 0) {
            selectedList = todoLists.get(0);
        } else {
            selectedList = null;
        }
    }
}
