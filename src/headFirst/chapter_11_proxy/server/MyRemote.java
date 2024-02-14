package headFirst.chapter_11_proxy.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Интерфейс удаленного доступа, который определяет доступные методы для вызова между удаленными помошниками
public interface MyRemote extends Remote {
    String sayHello() throws RemoteException;
}
