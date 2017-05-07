package au.com.subash.session;

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
public class TodoListFacade implements TodoListFacadeLocal {

    @PersistenceContext(unitName = "au.com.subash_Todo-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    
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
    public List<Todolist> getAll() {
        TypedQuery<Todolist> query = em.createNamedQuery("Todolist.findAll", Todolist.class);
        
        return query.getResultList();
    }

    @Override
    public boolean remove(int id) {
        Todolist found = find(id);
        
        if (null != found) {
            em.remove(found);
            return true;
        }
               
        return false;
    }

    @Override
    public int create(Todolist list) {
        em.persist(list);
        em.flush();
        return list.getId();
    }

    @Override
    public boolean update(Todolist list) {
        Todolist found = find(list.getId());
        
        if (null != found) {
            em.merge(list);
            return true;
        }

        return false;
    }
}
