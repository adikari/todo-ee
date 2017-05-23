package au.com.subash.session;

import au.com.subash.entity.AppUser;
import au.com.subash.entity.Appuser;
import au.com.subash.entity.TodoItem;
import au.com.subash.entity.TodoList;
import au.com.subash.entity.Todoitem;
import au.com.subash.entity.Todolist;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author subash
 */
@Stateless
@DeclareRoles({"USER"})
// TODO: Need to verify authority of user. compare user id
public class ManageTodoListFacade implements ManageTodoListFacadeRemote {

  @EJB
  private TodoListFacadeLocal todoListFacade;

  @EJB
  private TodoItemFacadeLocal todoItemFacade;

  @EJB
  private UserFacadeLocal userFacade;

  @Override
  public AppUser getUser(int id) {
    return userDAO2DTO(userFacade.getUser(id));
  }

  @Override
  public AppUser getUserByEmail(String email) {
    return userDAO2DTO(userFacade.getUserByEmail(email));
  }

  @Override
  @RolesAllowed({"USER"})
  public List<TodoList> getTodoLists(int userId) {
    List<Todolist> lists = todoListFacade.getAll(userId);

    if (null == lists) { return null; }

    return lists.stream()
          .map(t -> this.todoListDAO2DTO(t))
          .collect(Collectors.toList());
  }

  @Override
  @RolesAllowed({"USER"})
  public List<TodoItem> getTodoItems(int userId, int listId) {
    List<Todoitem> items = todoItemFacade.getAll(userId, listId);

    if (null == items) { return null; }

    return items.stream()
            .map(i -> this.todoItemDAO2DTO(i))
            .collect(Collectors.toList());
  }

  @Override
  @RolesAllowed({"USER"})
  public TodoItem getTodoItem(int userId, int listId, int todoId) {
    Todoitem item = todoItemFacade.find(userId, listId, todoId);

    return todoItemDAO2DTO(item);
  }

  @Override
  @RolesAllowed({"USER"})
  public TodoItem addTodoItem(int userId, int listId, TodoItem item) {
    Todoitem dao = todoItemDTO2DAO(item);

    Todoitem addedItem = todoItemFacade.create(userId, listId, dao);

    return todoItemDAO2DTO(addedItem);
  }

  @Override
  @RolesAllowed({"USER"})
  public TodoList addTodoList(int userId, TodoList list) {
    Todolist dao = todoListDTO2DAO(list);

    Todolist addedList = todoListFacade.create(userId, dao);

    return todoListDAO2DTO(addedList);
  }

  @Override
  @RolesAllowed({"USER"})
  public boolean updateTodoList(int userId, TodoList list) {
    Todolist dao = todoListDTO2DAO(list);

    return todoListFacade.update(userId, dao);
  }

  @Override
  @RolesAllowed({"USER"})
  public boolean deleteTodoList(int userId, int listId) {
    return todoListFacade.remove(userId, listId);
  }

  @Override
  @RolesAllowed({"USER"})
  public boolean deleteTodoItem(int userId, int listId, int itemId) {
    return todoItemFacade.remove(userId, listId, itemId);
  }

  @Override
  @RolesAllowed({"USER"})
  public boolean updateTodoItem(int userId, int listId, TodoItem item) {
    Todoitem dao = todoItemDTO2DAO(item);

    return todoItemFacade.update(userId, listId, dao);
  }

  /**
   * Convert user DAO to DTO
   *
   * @param user Logged in user
   * @return User DTO
   */
  private AppUser userDAO2DTO(Appuser user) {
    if (null == user) {
      return null;
    }

    return new AppUser(
      user.getId(),
      user.getEmail(),
      user.getFirstname(),
      user.getLastname(),
      user.getCategory()
    );
  }

  /**
   * Convert List DTO to DAO
   *
   * @param list List DTO
   * @return List DAO
   */
  private Todolist todoListDTO2DAO(TodoList list) {
    if (null == list) {
      return null;
    }

    return new Todolist(list.getId(), list.getTitle());
  }

  /**
   * Convert List DAO to DTO
   *
   * @param list List DAO
   * @return List DTO
   */
  private TodoList todoListDAO2DTO(Todolist list) {
    if (null == list) {
      return null;
    }

    return new TodoList(list.getId(), list.getTitle());
  }

  /**
   * Convert Item DAO to DTO
   *
   * @param item Item DAO
   * @return Item DTO
   */
  private TodoItem todoItemDAO2DTO(Todoitem item) {
    if (null == item) {
      return null;
    }

    return new TodoItem(
      item.getId(),
      item.getTitle(),
      item.getIscomplete()
    );
  }

  /**
   * Convert Item DTO to DAO
   *
   * @param item Item DTO
   * @return Item DAO
   */
  private Todoitem todoItemDTO2DAO(TodoItem item) {
    if (null == item) {
      return null;
    }

    return new Todoitem(item.getId(), item.getTitle(), item.getIscomplete());
  }
}
