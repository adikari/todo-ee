package au.com.subash.session;

import au.com.subash.entity.Todoitem;
import javax.ejb.Local;

/**
 *
 * @author subash
 */
@Local
public interface TodoItemFacadeLocal {

    /**
     * Update item
     * 
     * @param item Item to update
     * @return boolean
     */
    boolean update(Todoitem item);

    /**
     * Find item
     *
     * @param id Id of item to find
     * @return Found item
     */
    Todoitem find(int id);
}
