package au.com.subash.rest;

import java.util.Set;

import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class RestApplication extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> resources = new java.util.HashSet<>();

    addRestResourceClasses(resources);

    return resources;
  }


  /**
   * Register resources
   *
   * @param resources Resources to register
   */
  private void addRestResourceClasses(Set<Class<?>> resources) {
    resources.add(TodoListService.class);
  }
}
