package ex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by belows on 2017/1/9.
 */
public class Ex16 {

    private static class Task {

        private static final int size = 5;

        private Lock l1 = new ReentrantLock();
        private Lock l2 = new ReentrantLock();
        private Lock l3 = new ReentrantLock();

        public void test1() {
            try {
                l1.lock();
                for (int i=0; i<size; ++i) {
                    System.out.println("test1()");
                }
                Thread.yield();
            } finally {
                l1.unlock();
            }
        }

        public void test2() {
            try {
                l2.lock();
                for (int i=0; i<size; ++i) {
                    System.out.println("test2()");
                }
                Thread.yield();
            } finally {
                l2.unlock();
            }
        }

        public void test3() {
            try {
                l3.lock();
                for (int i=0; i<size; ++i) {
                    System.out.println("test3()");
                }
                Thread.yield();
            } finally {
                l3.unlock();
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
