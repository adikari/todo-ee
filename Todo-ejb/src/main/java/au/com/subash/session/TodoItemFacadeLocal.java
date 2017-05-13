package au.com.subash.session;

import au.com.subash.entity.Todoitem;

import java.util.List;

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


    /**
     * Get todo items in a list for a user
     *
     * @param userId User id
     * @param listId Todo list id
     * @return List of todo items
     */
    List<Todoitem> getTodoItems(int userId, int listId);

  /**
   * Get a todo item in a list for a user id
   *
   * @param userId User id
   * @param listId Todo list id
   * @param itemId Todo item id
   *
   * @return Single todo item
   */
  Todoitem getTodoItem(int userId, int listId, int todoId);
}
