package au.com.subash.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

@Path("/lists")
public class TodoListService {
  class User {
    private String name;
    private String gender;

    public User() { }

    /**
     *
     */
    public User(String name, String gender) {
      this.name = name;
      this.gender = gender;
    }

    /**
     * @return the name
     */
    public String getName() {
      return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
      this.name = name;
    }

    /**
     * @return the gender
     */
    public String getGender() {
      return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
      this.gender = gender;
    }

    }

  /**
   * Get list of todo lists
   *
   */
  @GET @Produces(MediaType.APPLICATION_JSON)
  public Response getTodoLists() {
    User user = new User("subash", "male");
    return Response.status(200).entity(user).build();
  }
}
