package ex;

import book.CachedThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by belows on 2017/1/9.
 */
public class Ex20 {
    public static class CachedThreadPool {
        public static void main(String[] args) throws InterruptedException {
            ExecutorService exec = Executors.newCachedThreadPool();
            List<Future<?>> futures = new ArrayList<>();
            for (int i = 0; i < 5; i++)
                futures.add(exec.submit(new Task()));
//            exec.shutdown();

            TimeUnit.MILLISECONDS.sleep(10);
            for (int i=0; i<5; ++i) {
                futures.get(i).cancel(true);
            }
            exec.shutdown();
        }
    }

    private static class Task implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(1500);
                System.out.println("running...");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CachedThreadPool.main(args);
    }
}
