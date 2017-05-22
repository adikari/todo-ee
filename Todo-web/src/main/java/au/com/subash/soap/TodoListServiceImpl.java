package au.com.subash.soap;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(endpointInterface = "au.com.subash.soap.TodoListService")
public class TodoListServiceImpl implements TodoListService {
  private final String message = "Hello, ";

  public TodoListServiceImpl() { }

  public static void main(String[] args) {
    Endpoint.publish("http://localhost:8080/todo-rest/ws/hello", new TodoListServiceImpl());
  }

  @Override
  public String sayHello(String name) {
    return message + name + ".";
  }
}
