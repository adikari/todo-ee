package au.com.subash.session;

import au.com.subash.entity.TodoItem;
import au.com.subash.entity.TodoList;
import au.com.subash.entity.Todoitem;
import au.com.subash.entity.Todolist;
import java.util.List;
import java.util.stream.Collectors;
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
        return todoListFacade.getAll().stream()
                .map(t -> this.todoListDAO2DTO(t))
                .collect(Collectors.toList());
    }

    @Override
    public boolean removeTodoList(int id) {
        return todoListFacade.remove(id);
    }

    @Override
    public boolean updateTodoItem(TodoItem item) {
        return todoItemFacade.update(todoItemDTO2DAO(item));
    }

    @Override
    public TodoList addTodoList(TodoList list) {
        Todolist addedList = todoListFacade.create(todoListDTO2DAO(list));
        
        return todoListDAO2DTO(addedList);
    }

    @Override
    public boolean updateTodoList(TodoList list) {
        return todoListFacade.update(todoListDTO2DAO(list));
    }
    
    /**
     * Convert List DTO to DAO
     * 
     * @param list List DTO
     * @return List DAO
     */
    private Todolist todoListDTO2DAO(TodoList list) {
        if (null == list) {
            return null;
        }
        
        Todolist dao = new Todolist(list.getId(), list.getTitle());
        
        List<Todoitem> items = list.getTodoitemCollection().stream()
                .map((TodoItem t) -> {
                    Todoitem item = todoItemDTO2DAO(t);
                    item.setTodolistid(dao);
                    return item;
                })
                .collect(Collectors.toList());
        
        dao.setTodoitemCollection(items);
        
        return dao;
    }
    
    /**
     * Convert List DAO to DTO
     * 
     * @param list List DAO
     * @return List DTO
     */
    private TodoList todoListDAO2DTO(Todolist list) {
        if (null == list) {
            return null;
        }
        
        List<TodoItem> todoitemCollection = list.getTodoitemCollection().stream()
                .map(t -> todoItemDAO2DTO(t))
                .collect(Collectors.toList());
        
        return new TodoList(list.getId(), list.getTitle(), todoitemCollection);
    }
    
    /**
     * Convert Item DAO to DTO
     * 
     * @param item Item DAO
     * @return Item DTO
     */
    private TodoItem todoItemDAO2DTO(Todoitem item) {
        if (null == item) {
            return null;
        }
        
        return new TodoItem(
                item.getId(), 
                item.getTitle(),
                item.getTodolistid().getId(),
                item.getIscomplete()
        );
    }

    /**
     * Convert Item DTO to DAO
     * 
     * @param item Item DTO
     * @return Item DAO
     */
    private Todoitem todoItemDTO2DAO(TodoItem item) {
        if (null == item) {
            return null;
        }
        
        return new Todoitem(item.getId(), item.getTitle(), item.getIscomplete()); 
    }
}
