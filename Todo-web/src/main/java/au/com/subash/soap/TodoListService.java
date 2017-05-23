package au.com.subash.soap;

import java.util.List;

import javax.jws.WebMethod;
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

  @WebMethod
  void addTodoList(int userId, TodoList list);

//   @WebMethod
//   List<TodoList> getTodoLists(int userId);

  @WebMethod
  void deleteTodoList(int userId, int listId);

  @WebMethod
  void updateTodoList(int userId, TodoList list);

  // @WebMethod
  // List<TodoList> getTodoListItems(int userId, int listId);

  @WebMethod
  TodoItem addTodoItem(int userId, int listId, TodoItem item);

  @WebMethod
  TodoItem getTodoItem(int userId, int listId, int itemId);

  @WebMethod
  void deleteTodoItem(int userId, int listId, int itemId);

  @WebMethod
  void updateTodoItem(int userId, int listId, TodoItem item);
}
