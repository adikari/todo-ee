package au.com.subash.rest;

import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.jackson.JacksonFeature;

@ApplicationPath("/api")
public class RestApplication extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    Set<Class<?>> resources = new java.util.HashSet<>();

    resources.add(TodoListService.class);

    resources.add(ObjectMapperProvider.class);
    resources.add(JacksonFeature.class);

    return resources;
  }
}
