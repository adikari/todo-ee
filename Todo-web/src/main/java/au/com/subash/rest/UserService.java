package au.com.subash.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import au.com.subash.entity.AppUser;
import au.com.subash.entity.TodoItem;
import au.com.subash.entity.TodoList;
import au.com.subash.session.ManageTodoListFacadeRemote;

@Path("/{userId}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserService {

  @EJB
  private ManageTodoListFacadeRemote facade;

  /**
   * Get user by id
   *
   * @param User id
   *
   * @return Response with found user
   */
  @GET
  public Response getUser(@PathParam("userId") int userId) {
    AppUser user = facade.getUser(userId);

    ResponseBuilder response = null != user ? Response.ok() : Response.noContent();

    return response.entity(user).build();
  }

  /**
   * Get todo lists for user
   *
   * @param id User id
   *
   * @return Response with the found todolists
   */
  @GET @Path("/lists")
  public Response getTodoLists(@PathParam("userId") int userId) {
    List<TodoList> todoLists = facade.getTodoLists(userId);

    ResponseBuilder response = null != todoLists ? Response.ok() : Response.noContent();

    return response.entity(todoLists).build();
  }

  /**
   * Add single todo item in a list
   *
   * @param listId Todo list id
   *
   * @return Response with found todo item
   */
  @POST @Path("/lists")
  public Response addTodoList(
    @PathParam("userId") int userId,
    TodoList list,
    @Context UriInfo uriInfo
  ) {
    TodoList addedList = facade.addTodoList(userId, list);

    ResponseBuilder response;

    if (null == addedList) {
      response = Response.noContent();
    } else {
      UriBuilder builder = uriInfo.getAbsolutePathBuilder();
      builder.path(Integer.toString(addedList.getId()));

      response = Response.created(builder.build());
    }

    return response.entity(addedList).build();
  }

  /**
   * Get todo items in a todo list
   * @param userId User id
   * @param listId Todo list id
   *
   * @return Response with found todo items
   */
  @GET @Path("/lists/{listId}/items")
  public Response getTodoListItems(
    @PathParam("userId") int userId,
    @PathParam("listId") int listId
  ) {
    List<TodoItem> items = facade.getTodoItems(userId, listId);

    ResponseBuilder response = null != items ? Response.ok() : Response.noContent();

    return response.entity(items).build();
  }

  /**
   * Add single todo item in a list
   *
   * @param listId Todo list id
   *
   * @return Response with found todo item
   */
  @POST @Path("/lists/{listId}/items")
  public Response addTodoItem(
    @PathParam("userId") int userId,
    @PathParam("listId") int listId,
    TodoItem item,
    @Context UriInfo uriInfo
  ) {
    TodoItem addedItem = facade.addTodoItem(userId, listId, item);

    ResponseBuilder response;

    if (null == addedItem) {
      response = Response.noContent();
    } else {
      UriBuilder builder = uriInfo.getAbsolutePathBuilder();
      builder.path(Integer.toString(addedItem.getId()));

      response = Response.created(builder.build());
    }

    return response.entity(addedItem).build();
  }

  /**
   * Get single todo item in a list
   *
   * @param userId User id
   * @param listId Todo list id
   * @param itemId Todo item id
   *
   * @return Response with found todo item
   */
  @GET @Path("/lists/{listId}/items/{itemId}")
  public Response getTodoItem(
    @PathParam("userId") int userId,
    @PathParam("listId") int listId,
    @PathParam("itemId") int itemId
  ) {
    TodoItem item = facade.getTodoItem(userId, listId, itemId);

    ResponseBuilder response = null != item ? Response.ok() : Response.noContent();

    return response.entity(item).build();
  }

  @DELETE @Path("/lists/{listId}/items/{itemId}")
  public Response deleteTodoItem(
    @PathParam("userId") int userId,
    @PathParam("listId") int listId,
    @PathParam("itemId") int itemId
  ) {
    boolean isDeleted = facade.deleteTodoItem(userId, listId, itemId);

    ResponseBuilder response = isDeleted ? Response.ok() : Response.noContent();

    return response.build();
  }

  @PUT @Path("/lists/{listId}/items/{itemId}")
  public Response updateTodoItem(
    @PathParam("userId") int userId,
    @PathParam("listId") int listId,
    TodoItem item
  ) {
    boolean isUpdated = facade.updateTodoItem(userId, listId, item);

    ResponseBuilder response = isUpdated ? Response.ok() : Response.noContent();

    return response.build();
  }
}
