package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain
{
  public static void main(String[] args) throws IOException
  {
    ServerSocket serverSocket = new ServerSocket(1235);

    Socket socket = serverSocket.accept();
    PrintWriter out  = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    out.println("How can i help you?");
    String type = in.readLine();
    out.println("Argument tak");
    String argument = in.readLine();
    if (type.equalsIgnoreCase("lower case")){
      out.println(argument.toLowerCase());
    }else if (type.equalsIgnoreCase("upper case")){
      out.println(argument.toUpperCase());
    }else {
      out.println("I cant help you with that");
    }




  }
}
