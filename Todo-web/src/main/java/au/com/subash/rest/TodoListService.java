package au.com.subash.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/lists")
public class TodoListService {

  /**
   * Get list of todo lists
   *
   */
  @Produces("text/plain")
  @GET
  public String getTodoLists() {
    return "list of todo lists";
  }
}
