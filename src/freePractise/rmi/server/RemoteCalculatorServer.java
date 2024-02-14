package freePractise.rmi.server;

import java.rmi.RemoteException;

public class RemoteCalculatorServer implements Calculator {
    @Override
    public int multiply(int a, int b) throws RemoteException {
        return a * b;
    }
}
