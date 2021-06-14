package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClient
{
  public static void main(String[] args)
      throws RemoteException, NotBoundException
  {
  RMIClient client = new RMIClient();
  client.start();

    Scanner scanner = new Scanner(System.in);

    while (true){
      System.out.println("Give input: ");
      String input = scanner.nextLine();

      client.toUppercase(input);
    }
  }
}
