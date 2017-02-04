package ex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by belows on 2017/1/10.
 */
public class Ex22 {

    static volatile boolean flag = false;

    private static class Task1 implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    flag = true;
                } catch (InterruptedException e) {}
            }
        }
    }

    private static class Task2 implements Runnable {
        @Override
        public void run() {
            while (true) {
                if (flag) {
                    System.out.println("flag == true");
                    flag = false;
                }
            }
        }
    }

    private static Object o = new Object();

    private static class Task3 implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    flag = true;
                    synchronized (o) {
                        o.notifyAll();
                    }
                } catch (InterruptedException e) {}
            }
        }
    }

    private static class Task4 implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (o) {
                    while (!flag) {
                        try {
                            o.wait();
                            flag = false;
                            System.out.println("change");
                        } catch (InterruptedException e) {
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Task3());
        exec.execute(new Task4());
        exec.shutdown();
    }
}
