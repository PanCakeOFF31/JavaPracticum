package freePractise.rmi.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    int multiply(int a, int b) throws RemoteException;
}
