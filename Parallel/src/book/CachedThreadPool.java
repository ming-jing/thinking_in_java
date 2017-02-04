package book;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by belows on 2017/1/4.
 */
public class CachedThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++)
            exec.execute(new Task());
        exec.shutdownNow();
    }

    private static class Task implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(500);
                System.out.println("running...");
            } catch (Exception e) {}
        }
    }
}
