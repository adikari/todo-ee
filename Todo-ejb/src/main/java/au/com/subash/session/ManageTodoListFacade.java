package au.com.subash.session;

import au.com.subash.entity.AppUser;
import au.com.subash.entity.Appuser;
import au.com.subash.entity.TodoItem;
import au.com.subash.entity.TodoList;
import au.com.subash.entity.Todoitem;
import au.com.subash.entity.Todolist;
import java.util.List;
import java.util.stream.Collectors;
// import javax.annotation.security.DeclareRoles;
// import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author subash
 */
@Stateless
// @DeclareRoles({"USER"})
public class ManageTodoListFacade implements ManageTodoListFacadeRemote {

  @EJB
  private TodoListFacadeLocal todoListFacade;

  @EJB
  private TodoItemFacadeLocal todoItemFacade;

  @EJB
  private UserFacadeLocal userFacade;

  @Override
  // @RolesAllowed({"USER"})
  public List<TodoList> getTodoLists(int userId) {
    List<Todolist> lists = todoListFacade.getTodoLists(userId);

    if (null == lists) {
      return null;
    }

    return lists.stream()
          .map(t -> this.todoListDAO2DTO(t))
          .collect(Collectors.toList());
  }

  @Override
  // @RolesAllowed({"USER"})
  public boolean removeTodoList(int id) {
    return todoListFacade.remove(id);
  }

  @Override
  // @RolesAllowed({"USER"})
  public boolean updateTodoItem(TodoItem item) {
    Todolist list = todoListFacade.find(item.getTodolistid());

    if (null == list) {
      return false;
    }

    return todoItemFacade.update(todoItemDTO2DAO(item, list));
  }

  @Override
  // @RolesAllowed({"USER"})
  public TodoList addTodoList(TodoList list) {
    Todolist addedList = todoListFacade.create(todoListDTO2DAO(list));

    return todoListDAO2DTO(addedList);
  }

  @Override
  // @RolesAllowed({"USER"})
  public TodoList updateTodoList(TodoList list) {
    Todolist updatedList = todoListFacade.update(todoListDTO2DAO(list));

    return todoListDAO2DTO(updatedList);
  }

  @Override
  public AppUser getUser(int id) {
    return userDAO2DTO(userFacade.getUser(id));
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

    Todolist dao = new Todolist(list.getId(), list.getTitle());

    List<Todoitem> items = list.getTodoitemCollection().stream()
            .map(item -> todoItemDTO2DAO(item, dao))
            .collect(Collectors.toList());

    dao.setTodoitemList(items);
    dao.setAppuser(userFacade.getUser(1));

    return dao;
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

    List<TodoItem> todoitemCollection = list.getTodoitemList().stream()
            .map(t -> todoItemDAO2DTO(t))
            .collect(Collectors.toList());

    return new TodoList(list.getId(), list.getTitle(), todoitemCollection);
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
      item.getTodolistid().getId(),
      item.getIscomplete()
    );
  }

  /**
   * Convert Item DTO to DAO
   *
   * @param item Item DTO
   * @return Item DAO
   */
  private Todoitem todoItemDTO2DAO(TodoItem item, Todolist list) {
    if (null == item) {
      return null;
    }

    Todoitem dao = new Todoitem(item.getId(), item.getTitle(), item.getIscomplete());
    dao.setTodolistid(list);

    return dao;
  }
}
