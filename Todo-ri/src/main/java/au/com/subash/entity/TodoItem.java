package au.com.subash.entity;

/**
 *
 * @author subash
 */
public class TodoItem {
    private String title;
    private boolean isComplete;
    
    public TodoItem(String title, boolean isComplete) {
        this.title = title;
        this.isComplete = isComplete;
    }
    
    public TodoItem(String title) {
        this(title, false);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }
}
