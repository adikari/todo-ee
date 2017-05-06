package au.com.subash.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author subash
 */
@Stateless
public class TodoItemFacade implements TodoItemFacadeLocal {
    
    @PersistenceContext(unitName = "au.com.subash_Todo-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
}
