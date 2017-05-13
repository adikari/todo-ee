package au.com.subash.session;

import au.com.subash.entity.Appuser;
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
public class TodoListFacade implements TodoListFacadeLocal {

  @PersistenceContext(unitName = "au.com.subash_Todo-ejb_ejb_1.0-SNAPSHOTPU")
  private EntityManager em;

  @EJB
  private UserFacadeLocal userFacade;

  @Override
  public List<Todolist> getAll(int userId) {
    Appuser user = userFacade.getUser(userId);

    if (null != user) {
      return user.getTodolistList();
    }

    return null;
  }

  /**
   *
   * @param id
   * @return
   */
  @Override
  public Todolist find(int id) {
    return em.find(Todolist.class, id);
  }

  @Override
  public Todolist find(int userId, int listId) {
    Appuser user = userFacade.getUser(userId);

    if (null == user) { return null; }

    TypedQuery<Todolist> query = em.createNamedQuery(
      "Todolist.findByIdAndUserId", Todolist.class
    );

    query.setParameter("listId", listId);
    query.setParameter("userId", userId);

    List<Todolist> results = query.getResultList();

    return results.isEmpty() ? null : results.get(0);
  }

  @Override
  public Todolist create(int userId, Todolist list) {
    Appuser user = userFacade.getUser(userId);

    if (null == user) { return null; }

    list.setAppuser(user);
    em.persist(list);
    em.flush();

    return list;
  }
}
