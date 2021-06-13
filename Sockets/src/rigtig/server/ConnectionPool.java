package rigtig.server;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool
{
  private List<ServerSocketHandler> connections = new ArrayList<>();

  public void addHandler(ServerSocketHandler handler){
    connections.add(handler);
  }

  public void removeHandler(ServerSocketHandler handler){
    connections.remove(handler);
  }

  public void broadcastMessage(String message){
    for (ServerSocketHandler connection : connections)
    {
      connection.sendMessage(message);
    }
  }

}
