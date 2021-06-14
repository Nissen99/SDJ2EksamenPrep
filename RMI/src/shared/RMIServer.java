package shared;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServer extends Remote
{
  void toUppercase(String message) throws RemoteException;
  void registerClient(CallBackClient callBackClient) throws RemoteException;
  void start() throws AlreadyBoundException, RemoteException;
}
