package au.com.subash.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import au.com.subash.entity.TodoList;
import au.com.subash.session.ManageTodoListFacadeRemote;

@Path("/lists")
public class TodoListService {

  @EJB
  private ManageTodoListFacadeRemote facade;

  /**
   * Get list of todo lists
   *
   */
  @GET @Produces(MediaType.APPLICATION_JSON)
  public Response getTodoLists() {
    List<TodoList> todoLists = facade.getTodoLists("");
    return Response.status(200).entity(todoLists).build();
  }
}
