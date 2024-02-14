package freePractise.rmi.server;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import static freePractise.rmi.Network.BINDING_NAME;
import static freePractise.rmi.Network.PORT;

public class ServerMain {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
//        Создание удаленного объекта, с которым будет взаимодействие
        Remote server = new RemoteCalculatorServer();
//        Объявляю реестр удаленных объектов
        Registry registry = LocateRegistry.createRegistry(PORT);
//        Создание заглушки, которая инкапсулирует в себе процесс удаленного вызова
        Remote stub = UnicastRemoteObject.exportObject(server, 0);
//        Регистрация заглушки в реестре удаленных объектов
        registry.bind(BINDING_NAME, stub);
    }
}
