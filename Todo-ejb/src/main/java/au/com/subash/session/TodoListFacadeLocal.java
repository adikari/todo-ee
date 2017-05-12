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
   *  Get todo lists for given user
   *
   *  @param userId User id
   *  @return List of todo lists
   */
  List<Todolist> getTodoLists(int userId);

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
  Todolist update(Todolist list);
}
