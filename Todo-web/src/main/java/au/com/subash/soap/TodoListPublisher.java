package au.com.subash.soap;

import javax.xml.ws.Endpoint;

public class TodoListPublisher {

  public static void main(String[] args) {
    Endpoint.publish("http://localhost:8080/todo-rest/ws/hello", new TodoListServiceImpl());
  }
}
