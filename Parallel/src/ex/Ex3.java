package ex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by belows on 2017/1/4.
 */
public class Ex3 {
    private static class Task implements Runnable {

        private String name;

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("task " + name + " starting...");
            for (int i=0; i<3; ++i) {
                System.out.println("task " + name + " working...");
            }
            System.out.println("task " + name + "ending...");
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0; i<8; ++i) {
//            new Thread(new Task("Test" + i)).start();
            exec.execute(new Task("Test" + i));
        }
        exec.shutdown();
    }
}
