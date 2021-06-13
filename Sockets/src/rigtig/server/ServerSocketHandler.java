package rigtig.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{

  private Socket socket;
  private ConnectionPool connectionPool;
  private  PrintWriter out;
  private BufferedReader in;

  public ServerSocketHandler(Socket socket, ConnectionPool connectionPool)
      throws IOException
  {
  this.socket = socket;
  this.connectionPool = connectionPool;
  out = new PrintWriter(socket.getOutputStream(), true);
  in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
  }

  @Override public void run()
  {
    System.out.println("Client connected");

        try
        {
          while (true){
            String message = in.readLine();
            connectionPool.broadcastMessage(message);
          }

      }catch (IOException e)
        {
          e.printStackTrace();
        }


  }

  public void sendMessage(String message)
  {
  out.println("Message from server: " + message);
  }
}
