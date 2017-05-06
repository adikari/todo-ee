package au.com.subash.session;

import au.com.subash.entity.Todoitem;
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
    
    @Override
    public boolean update(Todoitem item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
