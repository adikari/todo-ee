package au.com.subash.session;

import au.com.subash.entity.Todoitem;
import au.com.subash.entity.Todolist;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author subash
 */
@Stateless
@LocalBean
public class TodoItemFacade implements TodoItemFacadeLocal {

  @PersistenceContext(unitName = "au.com.subash_Todo-ejb_ejb_1.0-SNAPSHOTPU")
  private EntityManager em;

  @EJB
  private TodoListFacadeLocal todoListFacade;

  @Override
  public Todoitem find(int id) {
    return em.find(Todoitem.class, id);
  }

  @Override
  public boolean update(Todoitem item) {
    Todoitem found = find(item.getId());

    if (null != found) {
      em.merge(item);
      return true;
    }

    return false;
  }

  @Override
  public List<Todoitem> getAll(int userId, int listId) {
    Todolist list = todoListFacade.find(userId, listId);

    if (null == list) { return null; }

    return list.getTodoitemList();
  }

  @Override
  public Todoitem find(int userId, int listId, int todoId) {
    TypedQuery<Todoitem> query = em.createNamedQuery(
      "Todoitem.findByListIdAndTodoId", Todoitem.class
    );

    query.setParameter("todoId", todoId);
    query.setParameter("listId", listId);
    query.setParameter("userId", userId);

    List<Todoitem> results = query.getResultList();

    return results.isEmpty() ? null : results.get(0);
  }

  @Override
  public Todoitem create(int userId, int listId, Todoitem item) {
    Todolist list = todoListFacade.find(userId, listId);

    if (null == list) { return null; }

    item.setTodolistid(list);
    em.persist(item);
    em.flush();

    return item;
  }

  @Override
  public boolean remove(int userId, int listId, int todoId) {
    Todoitem item = find(userId, listId, todoId);

    if (null == item) { return false; }

    em.remove(item);

    return true;
  }

  @Override
  public boolean update(int userId, int listId, Todoitem item) {
    Todoitem foundItem = find(userId, listId, item.getId());

    if (null == foundItem) { return false; }

    item.setTodolistid(foundItem.getTodolistid());
    em.merge(item);

    return true;
  }
}
