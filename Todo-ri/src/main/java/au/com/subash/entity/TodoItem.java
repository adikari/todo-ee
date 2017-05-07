package au.com.subash.entity;

/**
 *
 * @author subash
 */
public class TodoItem {
    private int id;
    private String title;
    private boolean iscomplete;
    private int todolistid;
    
    public TodoItem(int id, String title, int todolistId, boolean iscomplete) {
        this.id = id;
        this.title = title;
        this.iscomplete = iscomplete;
        this.todolistid = todolistId;
    }
    
    public TodoItem(int id, String title, int todolistId) {
        this(id, title, todolistId, false);
    }
    
    public TodoItem(String title, int todolistId) {
        this.title = title;
        this.todolistid = todolistId;
        this.iscomplete = false;
    }

    public int getTodolistid() {
        return todolistid;
    }

    public void setTodolistid(int todolistid) {
        this.todolistid = todolistid;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getIscomplete() {
        return iscomplete;
    }

    public void setIscomplete(boolean iscomplete) {
        this.iscomplete = iscomplete;
    }
}
