package ex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by belows on 2017/1/9.
 */
public class Ex15 {

    private static final int size = 5;

    private static class Task {

        private Object o1 = new Object();
        private Object o2 = new Object();
        private Object o3 = new Object();

        void test1() {
            synchronized (o1) {
                for (int i = 0; i < size; ++i) {
                    System.out.println("test1()");
                }
                Thread.yield();
            }
        }

         void test2() {
            synchronized (o1) {
                for (int i = 0; i < size; ++i) {
                    System.out.println("test2()");
                }
                Thread.yield();
            }
        }

         void test3() {
            synchronized (o1) {
                for (int i = 0; i < size; ++i) {
                    System.out.println("test3()");
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.test1();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.test2();
            }
        });
        t1.start();
        t2.start();
        task.test3();
    }
}
