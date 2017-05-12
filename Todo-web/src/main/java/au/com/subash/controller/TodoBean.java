package au.com.subash.controller;

import au.com.subash.entity.AppUser;
import au.com.subash.entity.TodoItem;
import au.com.subash.entity.TodoList;
import au.com.subash.session.ManageTodoListFacadeRemote;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author subash
 */
@Named(value = "todoBean")
@SessionScoped
public class TodoBean implements Serializable {

  private static final long serialVersionUID = 1L;

  @EJB
  private ManageTodoListFacadeRemote facade;

  private List<TodoList> todoLists;
  private TodoList selectedList;
  private String newTodoItem;
  private AppUser user;

  @PostConstruct
  public void init() {
    user = facade.getUser(1);
    todoLists = facade.getTodoLists(user.getId());

    if (todoLists.size() > 0) {
      selectedList = todoLists.get(0);
    } else {
      addTodoList();
    }
  }

  /**
   * Get logged in user
   *
   * @return Logged in user
   */
  public AppUser getUser() {
    return user;
  }

  /**
   * Get all lists
   *
   * @return TodoLists
   */
  public List<TodoList> getTodoLists() {
    return todoLists;
  }

  /**
   * Set lists
   *
   * @param todoLists TodoLists
   */
  public void setTodoLists(List<TodoList> todoLists) {
    this.todoLists = todoLists;
  }

  /**
   * Get selected list
   *
   * @return Selected List
   */
  public TodoList getSelectedList() {
    return selectedList;
  }

  /**
   * Set the selected list
   *
   * @param selectedList TodoList
   */
  public void setSelectedList(TodoList selectedList) {
    this.selectedList = todoLists.stream()
            .filter(l -> l.getId() == selectedList.getId())
            .findFirst()
            .get();
  }

  /**
   * Get new item
   *
   * @return Name of new item
   */
  public String getNewTodoItem() {
    return newTodoItem;
  }

  /**
   * Set new item
   *
   * @param newTodoItem Item title
   */
  public void setNewTodoItem(String newTodoItem) {
    this.newTodoItem = newTodoItem;
  }

  /**
   * Add new list
   */
  public void addTodoList() {
    TodoList list = facade.addTodoList(new TodoList("Untitled"));

    if (null != list) {
        selectedList = list;
        todoLists.add(selectedList);
    }
  }

  /**
   * Add item to the list
   */
  public void addTodoItem() {
    if (null == newTodoItem || newTodoItem.isEmpty()) {
        return;
    }

    // TodoItem item = new TodoItem(newTodoItem, selectedList.getId());

    // TODO: use different api
    // selectedList.getTodoitemCollection().add(item);

    TodoList updateList = updateSelectedList();

    if (null != updateList) {
        selectedList = updateList;
        setNewTodoItem(null);
    }
  }

  /**
   * Edit title of selected list
   *
   * @return boolean
   */
  public TodoList updateSelectedList() {
    return facade.updateTodoList(selectedList);
  }

  /**
   * Remove selected list. This will remove all its items
   *
   */
  public void removeTodoList() {

    if (!facade.removeTodoList(selectedList.getId())) {
        return;
    }

    todoLists.remove(selectedList);

    if (todoLists.size() > 0) {
        selectedList = todoLists.get(0);
    } else {
        selectedList = null;
    }
  }

  /**
   * Change status of the item
   *
   * @param todoItem TodoItem
   */
  public void toogleTodoItem(TodoItem todoItem) {
    // TodoItem item = selectedList.getTodoitemCollection().stream()
    //         .filter(t -> t.getTitle().equals(todoItem.getTitle()))
    //         .findFirst().get();

    // if (!facade.updateTodoItem(item)) {
    //     item.setIscomplete(!item.getIscomplete());
    // }
  }

  /**
   * Check if list is currently selected
   *
   * @param list
   * @return boolean
   */
  public boolean isSelectedList(TodoList list) {
    return selectedList.getId() == list.getId();
  }
}
