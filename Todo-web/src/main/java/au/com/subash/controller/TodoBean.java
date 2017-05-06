package au.com.subash.controller;

import au.com.subash.entity.TodoItem;
import au.com.subash.entity.TodoList;
import au.com.subash.session.ManageTodoListFacadeRemote;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author subash
 */
@Named(value = "todoBean")
@SessionScoped
public class TodoBean implements Serializable {

    @EJB
    private ManageTodoListFacadeRemote facade;
    
    private List<TodoList> todoLists;
    private TodoList selectedList;
    private String newTodoItem;

    public TodoBean() {
        todoLists = facade.getTodoLists();
        
        selectedList = todoLists.get(0);
    }

    /**
     * Get all lists
     * 
     * @return TodoLists
     */
    public List<TodoList> getTodoLists() {
        return todoLists;
    }

    /**
     * Set lists
     * 
     * @param todoLists TodoLists
     */
    public void setTodoLists(List<TodoList> todoLists) {
        this.todoLists = todoLists;
    }

    /**
     * Get selected list
     * 
     * @return Selected List 
     */
    public TodoList getSelectedList() {
        return selectedList;
    }

    /**
     * Set the selected list
     * 
     * @param selectedList TodoList
     */
    public void setSelectedList(TodoList selectedList) {       
        this.selectedList = todoLists.stream()
                .filter(l -> l.getTitle().equals(selectedList.getTitle()))
                .findFirst()
                .get();
    }
    
    /**
     * Get new item
     * 
     * @return Name of new item 
     */
    public String getNewTodoItem() {
        return newTodoItem;
    }

    /**
     * Set new item 
     * 
     * @param newTodoItem Item title 
     */
    public void setNewTodoItem(String newTodoItem) {
        this.newTodoItem = newTodoItem;
    }
    
    /**
     * Add new list
     */
    public void addTodoList() {
        selectedList = new TodoList("Untitled");
        todoLists.add(selectedList);
        facade.addTodoList(selectedList);
    }
    
    /**
     * Add item to the list
     */
    public void addTodoItem() {
        if (null == newTodoItem || newTodoItem.isEmpty()) { 
            return; 
        }
        
        selectedList.getTodoitemCollection().add(new TodoItem(newTodoItem));
        facade.updateTodoList(selectedList);
        
        setNewTodoItem(null);
    } 
    
    /**
     * Remove selected list. This will remove all its items
     * 
     */
    public void removeTodoList() {
        todoLists.remove(selectedList);
        facade.removeTodoList(selectedList.getId());
        
        if (todoLists.size() > 0) {
            selectedList = todoLists.get(0);
        } else {
            selectedList = null;
        }
    }
    
    /**
     * Change status of the item
     * 
     * @param todoItem TodoItem
     */
    public void toogleTodoItem(TodoItem todoItem) {
        TodoItem item = selectedList.getTodoitemCollection().stream()
                .filter(t -> t.getTitle().equals(todoItem.getTitle()))
                .findFirst().get();

        facade.updateTodoItem(item);
    }
}
