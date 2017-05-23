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

  @WebMethod
  AppUser getUser(int userId);

  @WebMethod(operationName = "addTodoList")
  void addTodoList(
    @WebParam(name = "userId") int userId,
    TodoList list
  );

  @WebMethod(operationName = "getTodoLists")
  TodoList[] getTodoLists(int userId);

  @WebMethod(operationName = "deleteTodoList")
  void deleteTodoList(int userId, int listId);

  @WebMethod(operationName = "updateTodoList")
  void updateTodoList(int userId, TodoList list);

  @WebMethod(operationName = "getTodoListItems")
  TodoList[] getTodoListItems(int userId, int listId);

  @WebMethod(operationName = "addTodoItem")
  TodoItem addTodoItem(int userId, int listId, TodoItem item);

  @WebMethod(operationName = "getTodoItem")
  TodoItem getTodoItem(int userId, int listId, int itemId);

  @WebMethod(operationName = "deleteTodoItem")
  void deleteTodoItem(int userId, int listId, int itemId);

  @WebMethod(operationName = "updateTodoItem")
  void updateTodoItem(int userId, int listId, TodoItem item);
}
