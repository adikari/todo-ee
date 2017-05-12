package au.com.subash.session;

import au.com.subash.entity.Appuser;
import au.com.subash.entity.Todolist;
import java.util.List;
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
public class UserFacade implements UserFacadeLocal {

  @PersistenceContext(unitName = "au.com.subash_Todo-ejb_ejb_1.0-SNAPSHOTPU")
  private EntityManager em;

  @Override
  public List<Todolist> getTodolists(String email) {
    Appuser user = getUserByEmail(email);

    if (null != user) {
      return user.getTodolistList();
    }

    return null;
  }

  @Override
  public Appuser getUser(int id) {
    return em.find(Appuser.class, id);
  }

  @Override
  public Appuser getUserByEmail(String email) {
    TypedQuery<Appuser> query = em.createNamedQuery("Appuser.findByEmail", Appuser.class);
    query.setParameter("email", email);

    return query.getSingleResult();
  }
}
