package server;

import shared.RMIServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {
    RMIServer server = new RMIServerImpl();
    server.start();

  }
}
