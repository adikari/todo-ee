package au.com.subash.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import au.com.subash.entity.AppUser;
import au.com.subash.entity.TodoList;
import au.com.subash.session.ManageTodoListFacadeRemote;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserService {

  @EJB
  private ManageTodoListFacadeRemote facade;

  /**
   * Get user by id
   *
   * @param User id
   * @return Response
   */
  @GET @Path("/{id}")
  public Response getUser(@PathParam("id") int id) {
    AppUser user = facade.getUser(id);

    ResponseBuilder response = null != user ? Response.ok() : Response.noContent();

    return response.entity(user).build();
  }

  /**
   * Get todo lists for user
   *
   * @param id User id
   * @return Response
   */
  @GET @Path("/{id}/lists")
  public Response getLists(@PathParam("id") int id) {
    List<TodoList> todoLists = facade.getTodoLists(id);

    ResponseBuilder response = null != todoLists ? Response.ok() : Response.noContent();

    return response.entity(todoLists).build();
  }
}
