package au.com.subash.controller;

import au.com.subash.entity.AppUser;
import au.com.subash.entity.TodoItem;
import au.com.subash.entity.TodoList;
import au.com.subash.session.ManageTodoListFacadeRemote;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
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
  private List<TodoItem> todoItems;
  private TodoList selectedList;
  private String newTodoItem;
  private AppUser user;

  @PostConstruct
  public void init() {
    user = facade.getUserByEmail(getUserEmail());
    todoLists = facade.getTodoLists(user.getId());
    todoItems = new ArrayList<TodoItem>();

    if (null != todoLists && todoLists.size() > 0) {
      selectedList = todoLists.get(0);
      todoItems = facade.getTodoItems(user.getId(), selectedList.getId());
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
   * Get todoitems
   *
  * @return the todoItems
  */
  public List<TodoItem> getTodoItems() {
    return todoItems;
  }

  /**
   * Set todo items
   *
   * @param todoItems the todoItems to set
   * @return TOdo items
   */
  public void setTodoItems(List<TodoItem> todoItems) {
    this.todoItems = todoItems;
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

    todoItems = facade.getTodoItems(user.getId(), selectedList.getId());
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
    TodoList list = facade.addTodoList(user.getId(), new TodoList("Untitled"));

    if (null != list) {
        selectedList = list;
        todoLists.add(selectedList);
        todoItems = new ArrayList<TodoItem>();
    }
  }

  /**
   * Add item to the list
   */
  public void addTodoItem() {
    if (null == newTodoItem || newTodoItem.isEmpty()) {
        return;
    }

    TodoItem item = facade.addTodoItem(
        user.getId(),
        selectedList.getId(),
        new TodoItem(newTodoItem)
    );

    if (null != item) {
      todoItems.add(item);
      setNewTodoItem(null);
    }
  }

  /**
   * Edit title of selected list
   *
   * @return boolean
   */
  public boolean updateSelectedList() {
    return facade.updateTodoList(user.getId(), selectedList);
  }

  /**
   * Remove selected list. This will remove all its items
   *
   */
  public void removeTodoList() {

    if (!facade.deleteTodoList(user.getId(), selectedList.getId())) {
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
    TodoItem item = todoItems.stream()
            .filter(t -> t.getTitle().equals(todoItem.getTitle()))
            .findFirst().get();

    if (!facade.updateTodoItem(user.getId(), selectedList.getId(), item)) {
        item.setIscomplete(!item.getIscomplete());
    }
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

  /**
   * Get logged in user email
   *
   * @return User email address
   */
  private String getUserEmail() {
    return "subash.adikari@gmail.com";
  }
}
