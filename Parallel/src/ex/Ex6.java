package ex;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by belows on 2017/1/4.
 */
public class Ex6 {

    static Random random = new Random(System.currentTimeMillis());

    private static class Task implements Runnable {
        @Override
        public void run() {
            try {
                int s = random.nextInt(10) + 1;
                TimeUnit.SECONDS.sleep(s);
                System.out.println(s + "seconds end");
            } catch (Exception e) {}
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0; i<10; ++i) {
            exec.execute(new Task());
        }
        exec.shutdown();
    }
}
