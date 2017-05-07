package au.com.subash.session;

import au.com.subash.entity.Todolist;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author subash
 */
@Local
public interface TodoListFacadeLocal {
    Todolist find(int id);
    List<Todolist> getAll();
    boolean remove(int id);
    Todolist create(Todolist list);
    boolean update(Todolist list);
}
