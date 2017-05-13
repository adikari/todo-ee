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
   * Find todo list by user id and list id
   *
   * @param userId User id
   * @param listId List id
   *
   * @return Found Todo list
   */
  Todolist find(int userId, int listId);

  /**
   *  Get todo lists for given user
   *
   *  @param userId User id
   *  @return List of todo lists
   */
  List<Todolist> getAll(int userId);

  /**
   * Create new list
   *
   * @param userId User id
   * @param list New list to create
   *
   * @return Created list
   */
  Todolist create(int userId, Todolist list);
}
