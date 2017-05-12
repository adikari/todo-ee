package au.com.subash.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import au.com.subash.entity.AppUser;
import au.com.subash.session.ManageTodoListFacadeRemote;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserService {

  @EJB
  private ManageTodoListFacadeRemote facade;

  /**
   * Get user by id
   */
  @GET @Path("/{id}")
  public Response getUser(@PathParam("id") int id) {
    AppUser user = facade.getUser(id);

    return Response.ok().entity(user).build();
  }
}
