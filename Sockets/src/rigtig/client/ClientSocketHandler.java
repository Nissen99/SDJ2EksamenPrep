package rigtig.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocketHandler implements Runnable
{
  private Socket socket;
  private Client client;
  private PrintWriter out;
  private BufferedReader in;


  public ClientSocketHandler(Socket socket, Client client)
  {
    this.socket = socket;
    this.client = client;
    try
    {
      out = new PrintWriter(socket.getOutputStream(), true);
      in = new BufferedReader( new InputStreamReader(socket.getInputStream()));

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void run()
  {
    while (true){
      try
      {
        String message = in.readLine();
        client.messageReceived(message);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  }

  public void sendMessage(String message)
  {
    out.println(message);
  }
}
