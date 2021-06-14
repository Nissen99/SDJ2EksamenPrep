package client;

import shared.CallBackClient;
import shared.RMIServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient implements CallBackClient
{

  private RMIServer server;

  public RMIClient() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }
  public void start() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    server = (RMIServer) registry.lookup("Server");
    server.registerClient(this);
  }



  @Override public void update(String message)
  {
    System.out.println(message);
  }

  public void toUppercase(String input)
  {
    try
    {
      server.toUppercase(input);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }
}
