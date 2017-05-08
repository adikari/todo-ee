package au.com.subash.session;

import au.com.subash.entity.AppUser;
import au.com.subash.entity.TodoItem;
import au.com.subash.entity.TodoList;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author subash
 */
@Remote
public interface ManageTodoListFacadeRemote {
    
    /**
     * Get logged in user
     * 
     * @return Logged in user
     */
    AppUser getUser();
    
    /**
     * Get all lists
     * @return All found lists
     */
    List<TodoList> getTodoLists();
    
    /**
     * Add a new list
     * 
     * @param list List to add
     * @return Added list
     */
    TodoList addTodoList(TodoList list);
    
    /**
     * Remove list
     * 
     * @param id Id of list to remove
     * @return Success and failure
     */
    boolean removeTodoList(int id);
    
    /**
     * Update list
     * 
     * @param list List to update
     * @return Success or failure
     */
    TodoList updateTodoList(TodoList list);
    
    /**
     * Update Item
     * 
     * @param item Item to update
     * @return Success or failure
     */
    boolean updateTodoItem(TodoItem item);
}
