package au.com.subash.rest;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Provider
public class ObjectMapperProvider implements ContextResolver<ObjectMapper> {

  final ObjectMapper defaultObjectMapper;

  /**
  * Default constructor
  */
  public ObjectMapperProvider() {
    defaultObjectMapper = createObjectMapper();
  }

  @Override
  public ObjectMapper getContext(Class<?> type) {
    return defaultObjectMapper;
  }

  private ObjectMapper createObjectMapper() {
    final ObjectMapper result = new ObjectMapper();

    result.enable(SerializationFeature.INDENT_OUTPUT);

    return result;
  }
}
