package au.com.subash.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import au.com.subash.entity.AppUser;
import au.com.subash.entity.TodoItem;
import au.com.subash.entity.TodoList;

@WebService
@SOAPBinding(style = Style.RPC)
public interface TodoListService {

  /**
   * Get user by id
   *
   * @param userId User id
   * @return Found AppUser
   */
  @WebMethod(operationName = "getUser")
  AppUser getUser(@WebParam(name = "userId") int userId);

  /**
   * Add new todo list
   *
   * @param userId  User id
   * @param list    TodoList to add
   *
   * @return Added TodoList
   */
  @WebMethod(operationName = "addTodoList")
  TodoList addTodoList(
    @WebParam(name = "userId") int userId,
    TodoList list
  );

  /**
   * Get TodoLists for a user
   *
   * @param userId UserId
   *
   * @return Found TodoLists
   */
  @WebMethod(operationName = "getTodoLists")
  TodoList[] getTodoLists(@WebParam(name = "userId") int userId);

  /**
   * Delete todo list
   *
   * @param userId UserId
   * @param listId TodoList id
   *
   * @return Success or failure
   */
  @WebMethod(operationName = "deleteTodoList")
  boolean deleteTodoList(
    @WebParam(name = "userId") int userId,
    @WebParam(name = "listId") int listId
  );

  /**
   * Update TodoList
   *
   * @param userId UserId
   * @param list   Updated list
   *
   * @return Success or failure
   */
  @WebMethod(operationName = "updateTodoList")
  boolean updateTodoList(
    @WebParam(name = "userId") int userId,
    TodoList list
  );

  /**
   * Get Items in a TodoList
   *
   * @param userId User id
   * @param listId List id
   *
   * @return Found TodoItems
   */
  @WebMethod(operationName = "getTodoListItems")
  TodoItem[] getTodoListItems(
    @WebParam(name = "userId") int userId,
    @WebParam(name = "listId") int listId
  );

  /**
   * Add Todo Item in a list
   *
   * @param userId User id
   * @param listId List id
   * @param item   Item to add
   *
   * @return Added TodoItem
   */
  @WebMethod(operationName = "addTodoItem")
  TodoItem addTodoItem(
    @WebParam(name = "userId") int userId,
    @WebParam(name = "listId") int listId,
    TodoItem item
  );

  /**
   * Get Todo Item
   *
   * @param userId User id
   * @param listId List id
   * @param itemId Item id
   *
   * @return Found TodoItem
   */
  @WebMethod(operationName = "getTodoItem")
  TodoItem getTodoItem(
    @WebParam(name = "userId") int userId,
    @WebParam(name = "listId") int listId,
    @WebParam(name = "itemId") int itemId
  );

  /**
   * Delete a todo item
   *
   * @param userId User id
   * @param listId List id
   * @param itemId Item id
   *
   * @return Success or failure
   */
  @WebMethod(operationName = "deleteTodoItem")
  boolean deleteTodoItem(
    @WebParam(name = "userId") int userId,
    @WebParam(name = "listId") int listId,
    @WebParam(name = "itemId") int itemId
  );

  /**
   * Update Todo item
   *
   * @param userId User id
   * @param listId List id
   * @param item   Updated TodoItem
   *
   * @return Success or failure
   */
  @WebMethod(operationName = "updateTodoItem")
  boolean updateTodoItem(
    @WebParam(name = "userId") int userId,
    @WebParam(name = "listId") int listId,
    TodoItem item
  );
}
