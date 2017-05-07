package au.com.subash.session;

import au.com.subash.entity.Todolist;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author subash
 */
@Local
public interface TodoListFacadeLocal {
    /**
     * Find list
     * 
     * @param id Id of list to find
     * @return Found list
     */
    Todolist find(int id);
    
    /**
     * Get all lists
     * 
     * @return All lists
     */
    List<Todolist> getAll();
    
    /**
     * Remove a list
     * 
     * @param id Id of list to remove
     * @return Success or failure
     */
    boolean remove(int id);
    
    /**
     * Create new list
     * 
     * @param list New list to create
     * @return Created list
     */
    Todolist create(Todolist list);
    
    /**
     * Update list
     * 
     * @param list List to update
     * @return Success or failure
     */
    boolean update(Todolist list);
}
