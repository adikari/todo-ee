package au.com.subash.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import au.com.subash.entity.TodoList;
import au.com.subash.session.ManageTodoListFacadeRemote;

@Produces(MediaType.APPLICATION_JSON)
public class TodoListService {

  @EJB
  private ManageTodoListFacadeRemote facade;

  /**
   * Get todo lists for user
   *
   * @param id User id
   * @return Response
   */
  @GET
  public List<TodoList> getTodoLists() {
    return facade.getTodoLists(1);
  }
}
