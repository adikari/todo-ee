package au.com.subash.entity;

/**
 *
 * @author subash
 */
public class TodoItem {
    private int id;
    private String title;
    private boolean iscomplete;
    
    public TodoItem(String title, boolean iscomplete) {
        this.title = title;
        this.iscomplete = iscomplete;
    }
    
    public TodoItem(String title) {
        this(title, false);
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
