package au.com.subash.entity;

/**
 *
 * @author subash
 */
public class TodoItem {
    private String title;
    private Status status;
    
    public TodoItem(String title, Status status) {
        this.title = title;
        this.status = status;
    }
    
    public TodoItem(String title) {
        this(title, Status.Active);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
