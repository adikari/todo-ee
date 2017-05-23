package au.com.subash.soap;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebService;

import au.com.subash.entity.AppUser;
import au.com.subash.entity.TodoItem;
import au.com.subash.entity.TodoList;
import au.com.subash.session.ManageTodoListFacadeRemote;

@WebService(endpointInterface = "au.com.subash.soap.TodoListService")
public class TodoListServiceImpl implements TodoListService {

  @EJB
  private ManageTodoListFacadeRemote facade;

  public TodoListServiceImpl() { }

  @Override
  public AppUser getUser(int userId) {
    return facade.getUser(userId);
  }

  @Override
  public void addTodoList(int userId, TodoList list) {

  }

  @Override
  public void deleteTodoList(int userId, int listId) {
    // TODO Auto-generated method stub

  }

  @Override
  public void updateTodoList(int userId, TodoList list) {
    // TODO Auto-generated method stub

  }

  // @Override
  // public List<TodoList> getTodoListItems(int userId, int listId) {
  //   // TODO Auto-generated method stub
  //   return null;
  // }

  @Override
  public TodoItem addTodoItem(int userId, int listId, TodoItem item) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public TodoItem getTodoItem(int userId, int listId, int itemId) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deleteTodoItem(int userId, int listId, int itemId) {
    // TODO Auto-generated method stub

  }

  @Override
  public void updateTodoItem(int userId, int listId, TodoItem item) {
    // TODO Auto-generated method stub

  }

  //   @Override
//   public List<TodoList> getTodoLists(int userId) {
//     return null;
//   }
}
