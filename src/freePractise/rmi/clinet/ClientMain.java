package freePractise.rmi.clinet;

import freePractise.rmi.server.Calculator;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import static freePractise.rmi.Network.BINDING_NAME;
import static freePractise.rmi.Network.PORT;

public class ClientMain {
    public static void main(String[] args) throws RemoteException, NotBoundException {
//        Получаем реестр для порта, на котором сервер
        Registry registry = LocateRegistry.getRegistry(PORT);
//        Поиск удаленного объекта в реестре по уникальному имени
        Calculator calculator = (Calculator) registry.lookup(BINDING_NAME);
//        Конкретные вызовы у удаленного объекта
        System.out.println(calculator.multiply(10, 20));
        System.out.println(calculator.multiply(10, 30));
    }
}
