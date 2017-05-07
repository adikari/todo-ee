package au.com.subash.session;

import au.com.subash.entity.Todoitem;
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
}
