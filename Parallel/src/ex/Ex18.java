package ex;

import java.util.concurrent.*;

/**
 * Created by belows on 2017/1/9.
 */
public class Ex18 {

    private static class NonTask {
        private void test() {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("interrupted exception");
            }
            System.out.println("ending...");
        }
    }

    private static class Task implements Runnable {

        private NonTask task = new NonTask();

        @Override
        public void run() {
            task.test();
        }
    }

    public static void main(String[] args) {
//        Thread t = new Thread(new Task());
//        t.start();
//        try {
//            TimeUnit.MILLISECONDS.sleep(100);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        t.interrupt();

        ExecutorService exec = Executors.newCachedThreadPool();
        Future<?> f = exec.submit(new Task());
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (Exception e) {}
        f.cancel(true);
        exec.shutdown();
    }
}
