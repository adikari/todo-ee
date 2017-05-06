package au.com.subash.session;

import au.com.subash.entity.TodoItem;
import au.com.subash.entity.TodoList;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author subash
 */
@Remote
public interface ManageTodoListFacadeRemote {
    List<TodoList> getTodoLists();
    boolean addTodoList(TodoList list);
    boolean removeTodoList(int id);
    boolean updateTodoList(TodoList list);
    boolean toogleTodoItem(TodoItem item);
}
