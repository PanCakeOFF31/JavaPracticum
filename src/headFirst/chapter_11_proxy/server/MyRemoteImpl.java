package headFirst.chapter_11_proxy.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Класс реализации удаленного доступа, который будет выполнять настоящую удаленную работу.
//  UnicastRemoteObject нужен для обладания некоторой стандартной функциональностью
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    public MyRemoteImpl(int port) throws RemoteException {
        super(port);
    }

    @Override
    public String sayHello() {
        return "Server saying hello for you";
    }
}
