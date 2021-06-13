package rigtig.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
  private ConnectionPool connectionPool = new ConnectionPool();

  public void start(){
    try(ServerSocket serverSocket = new ServerSocket(1235)){
      while (true){
        Socket socket = serverSocket.accept();

        ServerSocketHandler handler = new ServerSocketHandler(socket, connectionPool);
        connectionPool.addHandler(handler);

        Thread t1 = new Thread(handler);
        t1.start();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
