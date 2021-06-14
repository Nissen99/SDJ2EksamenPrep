package server;

import shared.CallBackClient;
import shared.RMIServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RMIServerImpl implements RMIServer
{
  private ArrayList<CallBackClient> clients = new ArrayList<>();

  public RMIServerImpl() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  public void start() throws AlreadyBoundException, RemoteException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", this);
    System.out.println("Server started ");
  }


  public void registerClient(CallBackClient callBackClient){
    clients.add(callBackClient);
  }

  @Override
  public synchronized void toUppercase(String message){

    ArrayList<CallBackClient> failed = new ArrayList<>();

    for (CallBackClient client : clients)
    {
      try
      {
        client.update("From server: " + message.toUpperCase());
      }
      catch (RemoteException e)
      {
      failed.add(client);
      }
    }
    for (CallBackClient callBackClient : failed)
    {
      clients.remove(callBackClient);
    }
  }
}
