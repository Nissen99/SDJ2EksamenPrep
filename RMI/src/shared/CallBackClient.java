package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CallBackClient extends Remote
{
  void update(String message) throws RemoteException;

}
