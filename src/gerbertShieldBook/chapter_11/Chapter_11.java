package gerbertShieldBook.chapter_11;


import yandexPracticum.javaCoreIntroduction.theme_15_OOP.lesson_6.A.C;

import static helpers.Helpers.*;

// the title of a chapter
public class Chapter_11 {
    public static void chapter_11() {
        printArticle("Chapter 11. Многопоточное программирование");

//        The main thread
//        program_1();

//        Creating a thread with the Runnable interface
//        program_2();

//        Creating threads with Thread class extension
//        Creating the threads with extension of the Thread class
//        Creating the threads with the Thread class's extension
//        program_3();

//        isAlive() and join() methods
//        program_4();

//        A methods synchronization
//        program_5();

//        The Thread class's wait() and notify() methods
        program_6();

        printArticleEnding();

    }

    private static void program_1() {
        printSection("Program_1. The main thread");

        Thread mainThread = Thread.currentThread();
        printThreadInfo(mainThread);

        mainThread.setName("Main thread");
        mainThread.setPriority(6);
        printThreadInfo(mainThread);

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("i = " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Поток прерван другим потоком");
        }

        printSectionEnding();
    }

    private static void printThreadInfo(Thread thread) {
        System.out.println("thread.getName() = " + thread.getName());
        System.out.println("thread.getPriority() = " + thread.getPriority());
        System.out.println("thread.getId() = " + thread.getId());
        System.out.println("thread.toString() = " + thread.toString());
        System.out.println("thread.getThreadGroup() = " + thread.getThreadGroup());
    }

    private static void program_2() {
        printSection("Program_2. Creating a thread. The Runnable interface");

        Thread firstThread = new Thread(new FirstThread());
        firstThread.setName("FirstThread");
        firstThread.start();

        SecondThread secondThread = new SecondThread();
        secondThread.setThreadName("SecondThread");
        secondThread.start();

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Родительский поток - " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException ignored) {

        }


        printSectionEnding();
    }

    private static void program_3() {
        printSection("Program_3. Creating threads with Thread extension");

        TestThread thread1 = new TestThread("Thread-1");
        TestThread thread2 = new TestThread("Thread-2");

        thread1.start();
        thread2.start();

        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Родительский поток - " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException ignored) {

        }

        printSectionEnding();
    }

    private static void program_4() {
        printSection("Program_4. Методы isAlive() и join()");
        System.out.println("Запуск главного потока");

        SecondThread thread1 = new SecondThread("One");
        SecondThread thread2 = new SecondThread("Two");
        SecondThread thread3 = new SecondThread("Three");

        try {
            thread1.start();
            thread2.start();
            thread3.start();

            System.out.println("Поток " + thread1.getThreadName() + " работает: " + thread1.isAlive());
            System.out.println("Поток " + thread2.getThreadName() + " работает: " + thread2.isAlive());
            System.out.println("Поток " + thread3.getThreadName() + " работает: " + thread3.isAlive());

            thread1.join();
            thread2.join();
            thread3.join();

        } catch (InterruptedException e) {

        }

        System.out.println("Поток " + thread1.getThreadName() + " работает: " + thread1.isAlive());
        System.out.println("Поток " + thread2.getThreadName() + " работает: " + thread2.isAlive());
        System.out.println("Поток " + thread3.getThreadName() + " работает: " + thread3.isAlive());
        System.out.println("Завершение главного потока");

        printSectionEnding();
    }

    private static void program_5() {
        printSection("Program_5. Synchronization");
//        Здесь важно использовать один экземпляр, за синхронизированный метод которого будут конкурировать потоки.
        CallMe callMe = new CallMe();

        Caller caller1 = new Caller("Hello", callMe);
        Caller caller2 = new Caller("Synchronized", callMe);
        Caller caller3 = new Caller("World", callMe);

        caller1.start();
        caller2.start();
        caller3.start();

        caller1.join();
        caller2.join();
        caller3.join();

        System.out.println("Завершение основного потока");
        printSectionEnding();
    }

    private static void program_6() {
        printSection("Program_6. wait() and notify() methods");

        Common commonMethod = new Common();
        CallMaster callMaster1 = new CallMaster("Первая нить", commonMethod);
        CallMaster callMaster2 = new CallMaster("Вторая нить", commonMethod);

        callMaster1.start();
        callMaster2.start();

        callMaster1.join();
        callMaster2.join();

        System.out.println("Основная нить завершилась");
        printSectionEnding();
    }
    /*
    static void program_*() {
        printSection("");
        printSectionEnding();
    }*/

}

class FirstThread implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Дочерний №1 поток - " + Thread.currentThread().getName());
                Thread.sleep(500);
            }
        } catch (InterruptedException ignored) {

        }
    }
}

class SecondThread implements Runnable {
    private final Thread thread;

    SecondThread() {
        thread = new Thread(this, "Дочерний поток ");
    }

    SecondThread(String name) {
        thread = new Thread(this, name);
    }

    public String getThreadName() {
        return thread.getName();
    }

    public void setThreadName(String name) {
        thread.setName(name);
    }

    public void start() {
        thread.start();
    }

    public void join() throws InterruptedException {
        thread.join();
    }

    public boolean isAlive() {
        return thread.isAlive();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Дочерний поток - " + Thread.currentThread().getName());
                Thread.sleep(500);
            }
        } catch (InterruptedException ignored) {

        }
    }
}

class TestThread extends Thread {
    TestThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Дочерний поток - " + Thread.currentThread().getName());
                Thread.sleep(500);
            }
        } catch (InterruptedException ignored) {

        }
    }
}

class CallMe {
    //    synchronized
    public void call(String message) {
        System.out.print("[" + message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("This thread has been interrupted");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {
    private final Thread thread;
    private final String message;
    private final CallMe callMe;

    public Caller(String message, CallMe callMe) {
        this.callMe = callMe;
        this.message = message;
        thread = new Thread(this);
    }

    @Override
    public void run() {
        synchronized (callMe) {
            callMe.call(message);
        }
    }

    public void start() {
        thread.start();
    }

    public void join() {
        try {
            this.thread.join();
        } catch (InterruptedException e) {
            System.out.println("This thread has been interrupted");
        }
    }
}

class Common {
    private boolean order = true;
    private int counter = 0;
// Та нить, которая первая зайдет в метод, будет завершена последней
    public synchronized void call(String message) {
        System.out.println("Зашел в call() - " + message);
        if (order) {
            try {
                if (counter == 0 ){
                    order = !order;
                    ++counter;
                }
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            notify();
        }
        System.out.println("Вызов call() - " + message);
    }
}
class CallMaster implements Runnable {
    private final Thread thread;
    private final String message;
    private final Common common;

    public CallMaster(String message, Common common) {
        this.common = common;
        this.message = message;
        this.thread = new Thread(this);
    }

    @Override
    public void run() {
        synchronized (common) {
            common.call(message);
        }
    }

    public void start() {
        thread.start();
    }

    public void join() {
        try {
            this.thread.join();
        } catch (InterruptedException e) {
            System.out.println("This thread has been interrupted");
        }
    }
}








































