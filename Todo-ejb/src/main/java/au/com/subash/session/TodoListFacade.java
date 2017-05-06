package au.com.subash.session;

import au.com.subash.entity.TodoList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author subash
 */
@Stateless
public class TodoListFacade implements TodoListFacadeLocal {

    @PersistenceContext(unitName = "au.com.subash_Todo-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public List<TodoList> getTodoLists() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
