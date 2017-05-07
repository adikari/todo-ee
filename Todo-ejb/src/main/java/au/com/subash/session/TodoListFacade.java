package au.com.subash.session;

import au.com.subash.entity.Todolist;
import java.util.ArrayList;
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
public class TodoListFacade implements TodoListFacadeLocal {

    @PersistenceContext(unitName = "au.com.subash_Todo-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public List<Todolist> getAll() {
        TypedQuery<Todolist> query = em.createNamedQuery("Todolist.findAll", Todolist.class);
        
        return query.getResultList();
    }

    @Override
    public boolean remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(Todolist list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Todolist list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
