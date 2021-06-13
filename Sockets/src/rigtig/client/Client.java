package rigtig.client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client
{



  public void start() throws IOException
  {
    Socket socket = new Socket("127.0.0.1", 1235);


    ClientSocketHandler handler = new ClientSocketHandler(socket, this);
    Thread t1 = new Thread(handler);
    t1.start();
    Scanner scanner = new Scanner(System.in);

    while (true){
    String message = scanner.nextLine();
    handler.sendMessage(message);
  }
  }


  public void messageReceived(String message)
  {
    System.out.println(message);
  }
}

