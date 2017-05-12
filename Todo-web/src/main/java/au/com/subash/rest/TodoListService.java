package au.com.subash.rest;

import javax.ws.rs.GET;

public class TodoListService {

  private int userId;

  /**
   * Default constructor
   */
  public TodoListService(int userId) {
    this.userId = userId;
  }

  /**
   * Get all todo lists for user
   *
   * @return List of todo lists
   */
  @GET
  public int getTodoLists() {
    return userId;
  }
}
