package ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by belows on 2017/2/10.
 */
public class Ex32 {

    private static class Count {
        private int value;
        private Random random = new Random(47);
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        public int increment() {
            lock.lock();
            try {
                if (random.nextBoolean())
                    Thread.yield();
                return ++value;
            } finally {
                lock.unlock();
            }
        }

        public int getValue() {
            lock.lock();
            try {
                return value;
            } finally {
                lock.unlock();
            }
        }
    }

    private static class Entrance implements Runnable {
        public static List<Entrance> entrances = new ArrayList<>();
        public static CountDownLatch latch;

        private static int index = 0;
        private final int id = ++index;

//        public static boolean isCanceled = false;

        private int number;
        private static Count count = new Count();

        public Entrance() {
            entrances.add(this);
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    ++number;
                    count.increment();

                    System.out.println("Entrance " + id + ":" + number + ",Total:" + count.getValue());
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            } catch (Exception e) {}
            System.out.println("Stopping Entrance " + id + ":"+number);
            latch.countDown();
//            System.out.println(latch.toString());
        }

        public static int getTotal() {
            return count.getValue();
        }

        public static int sumEntances() {
            int sum = 0;
            for (Entrance entrance :entrances) {
                sum += entrance.number;
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Entrance.latch = new CountDownLatch(5);
        ExecutorService exec  = Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(1).execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Entrance.latch.await();
                    System.out.println(Entrance.getTotal());
                    System.out.println(Entrance.sumEntances());
                } catch (InterruptedException e) {
                    System.out.println("wait exception");
                }
            }
        });
        for (int i=0; i<5; ++i) {
            exec.execute(new Entrance());
        }
        try {
            TimeUnit.MILLISECONDS.sleep(500);
            exec.shutdownNow();
        } catch (InterruptedException e) {}
    }
}
