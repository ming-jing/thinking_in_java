package ex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by belows on 2017/1/10.
 */
public class Ex21 {

    private static class Task1 implements Runnable {
        @Override
        public void run() {
            synchronized (this) {
                try {
                    wait();
                    System.out.println("working...");
                } catch (InterruptedException e) {
                    System.out.println("interrupted exception");
                }
            }
        }
    }

    private static class Task2 implements Runnable {

        Task1 task1;

        public Task2(Task1 task1) {
            this.task1  =task1;
        }

        @Override
        public void run() {
            synchronized (task1) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (Exception e) {}
                task1.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(task1);

        Task2 task2 = new Task2(task1);
        exec.execute(task2);
        exec.shutdown();
    }
}
