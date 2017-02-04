package ex;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by belows on 2017/1/9.
 */
public class Ex17 {

    private static class Counter {
        private int count = 0;

        public void increase() {
            synchronized (this) {
                ++count;
            }
        }

        public int getCount() {
            synchronized (this) {
                return count;
            }
        }
    }

    private static class Sensor implements Runnable {
        private int count;
        private Counter counter;

        public static List<Sensor> sensors = new ArrayList<>();

        public static volatile boolean isCancle = false;

        public Sensor(Counter counter) {
            this.counter = counter;
            sensors.add(this);
        }

        public void increase() {
            synchronized (this) {
                ++count;
            }
        }

        public int getCount() {
            synchronized (this) {
                return count;
            }
        }

        @Override
        public void run() {
            while (!isCancle) {
                increase();
                counter.increase();
                Thread.yield();
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("sleep interrupted");
                }
            }
            System.out.println("finish...");
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i=0; i<6; ++i) {
            exec.execute(new Sensor(counter));
        }
        try {
            TimeUnit.SECONDS.sleep(2);
            Sensor.isCancle = true;
            exec.shutdown();
            if (!exec.awaitTermination(600,TimeUnit.MILLISECONDS)) {
                System.out.println("task not finish");
            }
            System.out.println("total:" + counter.getCount());
            int total = 0;
            for (Sensor sensor : Sensor.sensors) {
                total += sensor.getCount();
            }
            System.out.println("all:" + total);
        } catch (Exception e) {}

    }
}
