package headFirst.chapter_11_proxy;

import headFirst.chapter_11_proxy.gum.machine.GumballMachine;
import headFirst.chapter_11_proxy.gum.machine.GumballMonitor;
import headFirst.chapter_11_proxy.server.MyRemote;
import headFirst.chapter_11_proxy.server.MyRemoteImpl;

import java.rmi.Naming;
import java.rmi.RemoteException;

import static helpers.Helpers.*;

public class Chapter_11_proxy {
    public static void chapter_11() {
        printArticle("Proxy Pattern");

        program_1();
        program_2();

        printArticleEnding();
    }

    private static void program_1() {
        printSection("Program_1. ");

        GumballMachine machine = new GumballMachine("Gubkin", 10);
        GumballMonitor monitor = new GumballMonitor(machine);

        monitor.report();

        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. rmi");

        try {
            MyRemote service = new MyRemoteImpl(8081);
            Naming.rebind("RemoteHello",service);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        printSectionEnding();
    }

}
