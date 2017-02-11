package ex;

import java.util.concurrent.*;

/**
 * Created by belows on 2017/2/7.
 */
public class Ex30 {
    static BlockingDeque<Character> deque = new LinkedBlockingDeque<>();

    static class Sender implements Runnable {
        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    for (char c='A'; c<='z';++c) {
                        deque.put(c);
                        TimeUnit.MILLISECONDS.sleep(300);
                    }
                }
            } catch (InterruptedException e) {}
        }
    }

    static class Receiver implements Runnable {
        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    System.out.print("Read:" + deque.take() + ",");
                }
            }     catch (Exception e) {}
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Sender());
        exec.execute(new Receiver());
        try {
            TimeUnit.SECONDS.sleep(4);
            exec.shutdown();
        } catch (InterruptedException e) {}
    }
}
