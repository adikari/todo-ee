package au.com.subash.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserService {

  /**
   * Get user by id
   */
  @GET @Produces(MediaType.APPLICATION_JSON)
  public Response getUser() {
    return null;
  }
}
