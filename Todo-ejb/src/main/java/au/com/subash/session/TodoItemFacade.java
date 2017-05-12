package au.com.subash.session;

import au.com.subash.entity.Todoitem;
import au.com.subash.entity.Todolist;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
  public List<Todoitem> getTodoItems(int userId, int listId) {
    Todolist list = todoListFacade.find(userId, listId);

    if (null == list) { return null; }

    return list.getTodoitemList();
  }
}
