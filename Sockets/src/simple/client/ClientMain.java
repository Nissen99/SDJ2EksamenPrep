package simple.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain
{
  public static void main(String[] args) throws IOException
  {
    Socket socket = new Socket("127.0.0.1", 1235);
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
    Scanner scanner = new Scanner(System.in);

    String message = in.readLine();
    System.out.println(message);
    String output = scanner.nextLine();
    out.println(output);
    message = in.readLine();
    System.out.println(message);
    out.println(scanner.nextLine());
    message = in.readLine();
    System.out.println(message);

  }
}
