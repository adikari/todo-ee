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

  @WebMethod(operationName = "getUser")
  AppUser getUser(@WebParam(name = "userId") int userId);

  @WebMethod(operationName = "addTodoList")
  void addTodoList(
    @WebParam(name = "userId") int userId,
    TodoList list
  );

  @WebMethod(operationName = "getTodoLists")
  TodoList[] getTodoLists(@WebParam(name = "userId") int userId);

  @WebMethod(operationName = "deleteTodoList")
  void deleteTodoList(
    @WebParam(name = "userId") int userId,
    @WebParam(name = "listId") int listId
  );

  @WebMethod(operationName = "updateTodoList")
  void updateTodoList(
    @WebParam(name = "userId") int userId,
    TodoList list
  );

  @WebMethod(operationName = "getTodoListItems")
  TodoList[] getTodoListItems(
    @WebParam(name = "userId") int userId,
    @WebParam(name = "listId") int listId
  );

  @WebMethod(operationName = "addTodoItem")
  TodoItem addTodoItem(
    @WebParam(name = "userId") int userId,
    @WebParam(name = "listId") int listId,
    TodoItem item
  );

  @WebMethod(operationName = "getTodoItem")
  TodoItem getTodoItem(
    @WebParam(name = "userId") int userId,
    @WebParam(name = "listId") int listId,
    @WebParam(name = "itemId") int itemId
  );

  @WebMethod(operationName = "deleteTodoItem")
  void deleteTodoItem(
    @WebParam(name = "userId") int userId,
    @WebParam(name = "listId") int listId,
    int itemId
  );

  @WebMethod(operationName = "updateTodoItem")
  void updateTodoItem(
    @WebParam(name = "userId") int userId,
    @WebParam(name = "listId") int listId,
    TodoItem item
  );
}
