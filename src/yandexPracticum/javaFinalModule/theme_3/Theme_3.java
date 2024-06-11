package yandexPracticum.javaFinalModule.theme_3;

import helpers.coloredString.Colors;
import helpers.coloredString.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicInteger;

import static helpers.Helpers.*;

public class Theme_3 {
    private final static int COUNT = 20;
    private static volatile boolean stopped = false;
    private static volatile int x = 0;
    private static AtomicInteger atomicX = new AtomicInteger(0);
    private static volatile int z = 0;
    private static int AA = 0;
    private static int BB = 0;
    private static int CC = 0;


    public static void main(String[] args) throws InterruptedException {
        // Two threads
//        program_1();
        // Hello, world Runnable
//        program_2();
        // sleep()
//        program_3();
        //
//        program_4();
        //
//        program_5();
        // Не запускать. Бесконечные ждуны
//        program_6();
        //  Идиома обработки прерываний
//        program_7();
        //  Пример использование прерывания для остановки потока
//        program_8();
        //  data race or race condition
//        program_9();
        // AtomicX
//                program_10();
        // Синхронизация - synchronized
//        program_11();
        // Коллекции - java.util.concurrent
//        program_12();
        // Deadlock
//        program_13();
        //  Volatile
//        program_14();
        // За тебя и за того парня
//        program_15();
        program_16();
        //        program_17();
        //        program_18();
        //        program_19();
    }

    private static void program_1() throws InterruptedException {
        printSection("Program_1. Two threads");

        class ThreadOne extends Thread {
            public ThreadOne(String name) {
                super(name);
            }

            @Override
            public void run() {
                for (int i = 0; i < COUNT; i++) {
                    System.out.println(getName());
                    System.out.println("Сообщение: X");
                }
                super.run();
            }
        }

        // Метод start запускает поток, но не ждёт его завершения
        new ThreadOne("Поток №1").start();

        new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                System.out.println("Поток №2");
                System.out.println("Сообщение: X");
            }
        }).start();

        Logger.printMarkMessage(Thread.currentThread().getName());
        printSectionEnding();
    }

    private static void program_2() {
        printSection("Program_2. ");

        Runnable helloWorldRunnable = () -> {
            System.out.println("Hello, world!");
        };

        List<Thread> threads = new ArrayList();

        // 1. создать N потоков
        // 2. добавить их в threads
        for (int i = 0; i < 10; ++i) {
            threads.add(new Thread(helloWorldRunnable));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        printSectionEnding();
    }

    private static void program_3() throws InterruptedException {
        printSection("Program_3. sleep()");

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            Logger.printMarkMessage("Привет из потока");
        });

        Logger.printMarkMessage("main(): перед thread.start()");
        thread.start();

        // метод join() подождёт завершения потока thread
        thread.join();
        Logger.printMarkMessage("main(): конец");

        printSectionEnding();
    }

    private static void program_4() throws InterruptedException {
        printSection("Program_4. ");

        Thread mainThread = Thread.currentThread();

        Thread otherThread = new Thread(() -> {
            try {
//                Thread.sleep(500L);
                mainThread.join();
                Logger.printMessage("поток main завершился");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            Logger.printMessage("конец otherThread");
        });

        otherThread.start();

        Thread.sleep(100L);
        Logger.printMessage("конец main()");

        printSectionEnding();
    }

    private static void program_5() throws InterruptedException {
        printSection("Program_5. ");

        Thread thread = new Thread(() -> {
            while (!stopped) {
                if (getWeather().equals("ливень")) {
                    System.out.println("thread: возьмите зонт!");
                }

                try {
                    System.out.println("thread: засыпаю на 5 секунд");
                    Thread.sleep(5_000L);
                } catch (InterruptedException e) {
                    System.out.println("thread: меня прервали!");
                }

                System.out.println("thread: завершение потока");
            }
        });

        // Запуск "погодного" потока
        thread.start();
        Thread.sleep(1000L);
        // Немного ждём, чтобы погодный поток успел запуститься и вызвать свой sleep(5 сек)

        // stopped = true
        System.out.println("main(): присваиваю stopped = true");
        stopped = true;
        // Засекаем время, когда выставили stopped = true
        long stoppedIsTrueTime = System.currentTimeMillis();

        // тот самый interrupt()
        System.out.println("main(): прерываю поток thread");
        thread.interrupt();

        // Ждём завершения погодного потока
        thread.join();
        // Засекаем время, когда поток завершился
        long joinedTime = System.currentTimeMillis();

        // Делить на 10^9 надо, чтобы перевести наносекунды в секунды
        double secondsToStop = (joinedTime - stoppedIsTrueTime) / 1_000.0;
        System.out.printf(
                "main(): погодный поток остановился через %.1f секунд(ы) после stopped = true",
                secondsToStop);

        printSectionEnding();
    }

    private static String getWeather() {
        return "ливень";
    }

    private static void program_6() throws InterruptedException {
        printSection("Program_6. Бесконечные ждуны");

        Thread main = Thread.currentThread();

        Thread thread = new Thread(() -> {
            try {
                Logger.printMessage("thread поток ждем окончания main");
                main.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread.start();

        Logger.printMessage("main поток ждем окончания thread");
        thread.join();

        printSectionEnding();
    }

    private static void program_7() throws InterruptedException {
        printSection("Program_7. ");

        Thread thread = new Thread(() -> bigMethod());
        thread.start();

        Thread.sleep(500L);
        thread.interrupt();

        printSectionEnding();
    }

    private static void bigMethod() {
        smallMethod1();
        smallMethod2();
    }

    private static void smallMethod1() {
        try {
            Logger.printMessage("Выполнятся smallMethod1");
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            Logger.printMessage("smallMethod1 прерван", Colors.YELLOW);
            Thread.currentThread().interrupt();
        }
    }

    private static void smallMethod2() {
        try {
            Logger.printMessage("Выполнятся smallMethod2");
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            Logger.printMessage("smallMethod2 прерван", Colors.YELLOW);
            Thread.currentThread().interrupt();
        }
    }

    private static void program_8() throws InterruptedException {
        printSection("Program_8. ");

        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                Logger.printMessage("Поток thread выполняется");
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    Logger.printMessage("Поток thread прерван");
                    Thread.currentThread().interrupt();
                }
            }
        });

        thread.start();

        Thread.sleep(1500L);
        thread.interrupt();
        thread.join();

        printSectionEnding();
    }

    private static void program_9() throws InterruptedException {
        printSection("Program_9. ");
        final int n = 1_000_000;

        for (int j = 0; j < 10; ++j) {
            Thread incThread = new Thread(() -> {
                for (int i = 0; i < n; i++) {
                    ++x;
                }
            });

            Thread decThread = new Thread(() -> {
                for (int i = 0; i < n; i++) {
                    --x;
                }
            });

            incThread.start();
            decThread.start();

            incThread.join();
            decThread.join();

            System.out.println("x = " + x);
        }

        printSectionEnding();
    }

    private static void program_10() throws InterruptedException {
        printSection("Program_10. ");

        final int n = 1_000_000;

        for (int j = 0; j < 10; ++j) {
            Thread incThread = new Thread(() -> {
                for (int i = 0; i < n; i++) {
                    atomicX.getAndIncrement();
                }
            });

            Thread decThread = new Thread(() -> {
                for (int i = 0; i < n; i++) {
                    atomicX.getAndDecrement();
                }
            });

            incThread.start();
            decThread.start();

            incThread.join();
            decThread.join();

            System.out.println("atomicX = " + atomicX);
        }

        printSectionEnding();
    }

    private static void program_11() throws InterruptedException {
        printSection("Program_11. Синхронизация потоков");

        final int n = 1_000_000;
        Object monitor = new Object();
        Object monitor1 = new Object();

        Logger.printMessage("Запуск synchronized через разные мониторы");
        for (int j = 0; j < 10; ++j) {
            Thread incThread = new Thread(() -> {
                for (int i = 0; i < n; i++) {
                    synchronized (monitor) {
                        ++x;
                    }
                }
            });

            Thread decThread = new Thread(() -> {
                for (int i = 0; i < n; i++) {
                    synchronized (monitor1) {
                        --x;
                    }
                }

            });

            incThread.start();
            decThread.start();

            incThread.join();
            decThread.join();

            System.out.println("x = " + x);
        }

        x = 0;
        Logger.printMessage("Запуск synchronized через одинаковые мониторы - критические группы");
        for (int j = 0; j < 10; ++j) {
            Thread incThread = new Thread(() -> {
                for (int i = 0; i < n; i++) {
                    synchronized (monitor) {
                        ++x;
                    }
                }
            });

            Thread decThread = new Thread(() -> {
                for (int i = 0; i < n; i++) {
                    synchronized (monitor) {
                        --x;
                    }
                }

            });

            incThread.start();
            decThread.start();

            incThread.join();
            decThread.join();

            System.out.println("x = " + x);
        }

        printSectionEnding();
    }

    private static void program_12() throws InterruptedException {
        printSection("Program_12. Коллекции");

        Set<Integer> set = new ConcurrentSkipListSet<>();
//        Set<Integer> set = new HashSet<>();
        final int n = 100_000;

        for (int i = 0; i < n; i++) {
            set.add(i);
        }

        Thread oddThread = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 1) {
                    set.remove(i);
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    set.remove(i);
                }
            }
        });

        oddThread.start();
        evenThread.start();

        oddThread.join();
        evenThread.join();

        System.out.printf("set.size() = %d%n", set.size());

        printSectionEnding();
    }

    private static void program_13() {
        printSection("Program_13. Deadlock");
        final int tries = 100;

        Object chest = new Object();
        Object key = new Object();

//        Thread jack = new Thread(() -> {
//            for (int i = 0; i < tries; i++) {
//                synchronized (chest) {
//                    System.out.println("Джек захватил сундук");
//                    synchronized (key) {
//                        System.out.println("Джек захватил ключ");
//                        System.out.println("Джек: йо-хо-хо, сокровище теперь моё!");
//                        System.out.println("---");
//                    }
//                }
//            }
//        });
//
//        Thread bill = new Thread(() -> {
//            for (int i = 0; i < tries; i++) {
//                synchronized (key) {
//                    System.out.println("Билл захватил ключ");
//                    synchronized (chest) {
//                        System.out.println("Билл захватил сундук");
//                        System.out.println("Билл: йо-хо-хо, сокровище теперь моё!");
//                        System.out.println("---");
//                    }
//                }
//            }
//        });
//
        Thread jack = new Thread(() -> {
            for (int i = 0; i < tries; i++) {
                synchronized (chest) {
                    System.out.println("Джек захватил сундук");
                    synchronized (key) {
                        System.out.println("Джек захватил ключ");
                        System.out.println("Джек: йо-хо-хо, сокровище теперь моё!");
                        System.out.println("---");
                    }
                }
            }
        });
        Thread bill = new Thread(() -> {
            for (int i = 0; i < tries; i++) {
                synchronized (chest) {
                    System.out.println("Билл захватил сундук");
                    synchronized (key) {
                        System.out.println("Билл захватил ключ");
                        System.out.println("Билл: йо-хо-хо, сокровище теперь моё!");
                        System.out.println("---");
                    }
                }
            }
        });

        jack.start();
        bill.start();

        printSectionEnding();
    }

    private static void program_14() throws InterruptedException {
        printSection("Program_14. Volatile");
        final int times = 100_000_0;

        for (int k = 0; k < 1000; k++) {
            Thread writerThread = new Thread(() -> {
                for (int i = 0; i <= times; i++) {
                    z = i;
                }
                System.out.printf("z = %d (times = %d)%n", z, times);
            });

            Thread readerThread = new Thread(() -> {
                while (z < times) {
                    /* пусто */
                }
            });

            readerThread.start();
            writerThread.start();

            writerThread.join();
            System.out.println("Поток-писатель завершился");
            readerThread.join();
            System.out.println("Поток-читатель завершился");
        }

        printSectionEnding();
    }

    private static void program_15() throws InterruptedException {
        printSection("Program_15. За тебя и того парня");

        for (int i = 0; i < 1000; i++) {
            printSubSection();

            AA = 0;
            BB = 0;
            CC = 0;

            Thread thread1 = new Thread(() -> {
                AA = 10;
                BB = 20;
                CC = 30;
            });
            thread1.start();
            thread1.join();

            Thread thread2 = new Thread(() -> {
                Logger.printMessage(String.valueOf(AA), Colors.YELLOW);
                Logger.printMessage(String.valueOf(BB), Colors.GREEN);
                Logger.printMessage(String.valueOf(CC), Colors.BLUE);
            });
            thread2.start();
            thread2.join();
        }
        printSectionEnding();
    }

    private static void program_16() {
        printSection("Program_16. Пулы");


        printSectionEnding();
    }
}












