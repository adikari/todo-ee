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
  public TodoList addTodoList(int userId, TodoList list) {
    return facade.addTodoList(userId, list);
  }

  @Override
  public boolean deleteTodoList(int userId, int listId) {
    return facade.deleteTodoList(userId, listId);
  }

  @Override
  public boolean updateTodoList(int userId, TodoList list) {
    return facade.updateTodoList(userId, list);
  }

  @Override
  public TodoItem[] getTodoListItems(int userId, int listId) {
    List<TodoItem> items = facade.getTodoItems(userId, listId);

    TodoItem[] result = new TodoItem[items.size()];
    items.toArray(result);

    return result;
  }

  @Override
  public TodoItem addTodoItem(int userId, int listId, TodoItem item) {
    return facade.addTodoItem(userId, listId, item);
  }

  @Override
  public TodoItem getTodoItem(int userId, int listId, int itemId) {
    return facade.getTodoItem(userId, listId, itemId);
  }

  @Override
  public boolean deleteTodoItem(int userId, int listId, int itemId) {
    return facade.deleteTodoItem(userId, listId, itemId);
  }

  @Override
  public boolean updateTodoItem(int userId, int listId, TodoItem item) {
    return facade.updateTodoItem(userId, listId, item);
  }

  @Override
  public TodoList[] getTodoLists(int userId) {
    List<TodoList> lists = facade.getTodoLists(userId);
    TodoList[] result = new TodoList[lists.size()];

    lists.toArray(result);

    return result;
  }
}
