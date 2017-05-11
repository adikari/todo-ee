package au.com.subash.rest;

import java.util.Set;

import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class RestApplication extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> resources = new java.util.HashSet<>();

    resources.add(TodoListService.class);
    // resources.add(JsonFeature.class);

    return resources;
  }
}
