package au.com.subash.soap;

import javax.jws.WebService;

@WebService(endpointInterface = "au.com.subash.soap.TodoListService")
public class TodoListServiceImpl implements TodoListService {
  private final String message = "Hello, ";

  public TodoListServiceImpl() { }

  @Override
  public String sayHello(String name) {
    return message + name + ".";
  }
}
