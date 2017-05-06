package au.com.subash.session;

import au.com.subash.entity.TodoItem;
import au.com.subash.entity.TodoList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author subash
 */
@Stateless
public class ManageTodoListFacade implements ManageTodoListFacadeRemote {
    @EJB
    private TodoListFacade todoListFacade;
    
    @EJB
    private TodoItemFacade todoItemFacade;

    @Override
    public List<TodoList> getTodoLists() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeTodoList(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean toogleTodoItem(TodoItem item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addTodoList(TodoList list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateTodoList(TodoList list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
