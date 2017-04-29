package au.com.subash.entity;

/**
 *
 * @author subash
 */
public class TodoItem {
    private String title;
    private Status status;

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
