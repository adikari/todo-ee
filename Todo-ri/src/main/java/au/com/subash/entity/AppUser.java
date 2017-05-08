package au.com.subash.entity;

/**
 *
 * @author subash
 */
public class AppUser {
    private int id;
    private String email;
    private String firstname;
    private String lastname;
    private String category;

    public AppUser(int id, String email, String firstname, String lastname, String category) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public String getFullname() {
        return firstname + " " + lastname;
    }
}
