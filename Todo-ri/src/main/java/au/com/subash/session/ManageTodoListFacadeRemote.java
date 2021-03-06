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
   * @param id User id
   * @return Logged in user
   */
  AppUser getUser(int id);

  /**
   * Get user by email address
   *
   * @param email Email address
   * @return App user
   */
  AppUser getUserByEmail(String email);

  /**
   * Get all todo lists for user id
   *
   * @param userId User id
   * @return All found lists
   */
  List<TodoList> getTodoLists(int userId);

  /**
   *  Delete a todo list
   *
   * @param userId User id
   * @param listId List id
   *
   * @return Success or failure
   */
  boolean deleteTodoList(int userId, int listId);

  /**
   *  Update a todo list
   *
   * @param userId User id
   * @param list TodoList to update
   *
   * @return Success or failure
   */
  boolean updateTodoList(int userId, TodoList list);

  /**
   * Get all todo items in a list for a user id
   *
   * @param userId User id
   * @param listId Todo list id
   *
   * @return List of todo items
   */
  List<TodoItem> getTodoItems(int userId, int listId);

  /**
   * Get a todo item in a list for a user id
   *
   * @param userId User id
   * @param listId Todo list id
   * @param itemId Todo item id
   *
   * @return Single todo item
   */
  TodoItem getTodoItem(int userId, int listId, int todoId);

  /**
   * Add a todo item in a list
   *
   * @param userId User id
   * @param listId Todo list id
   * @param item TodoItem to add
   *
   * @return Added todo item
   */
  TodoItem addTodoItem(int userId, int listId, TodoItem item);

  /**
   *  Delete a todo item
   *
   * @param userId User id
   * @param listId List id
   * @param itemId Item id
   *
   * @return Success or failure
   */
  boolean deleteTodoItem(int userId, int listId, int itemId);

  /**
   *  Delete a todo item
   *
   * @param userId User id
   * @param listId List id
   * @param itemId Item id
   *
   * @return Success or failure
   */
  boolean updateTodoItem(int userId, int listId, TodoItem item);

  /**
   * Add todo list for a user
   *
   * @param userId User id
   * @param list Todo list to add
   *
   * @return Added todo list
  */
  TodoList addTodoList(int userId, TodoList list);
}
