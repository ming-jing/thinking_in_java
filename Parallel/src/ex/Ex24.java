package ex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by belows on 2017/2/7.
 */
public class Ex24 {

    private static class Meal {
        private static int index = 0;
        public final int id = ++index;

        @Override
        public String toString() {
            return "Meal:" + id;
        }
    }

    private static class Producer implements Runnable {
        Consumer consumer;
        Meal meal;

        public Producer(Consumer consumer) {
            this.consumer = consumer;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    synchronized (this) {
                        while (meal != null) {
                            wait();
                        }
                    }

                    synchronized (consumer) {
                        meal = new Meal();
                        TimeUnit.SECONDS.sleep(1);
                        consumer.notifyAll();
                    }
                }
            } catch (InterruptedException e) {}
        }
    }

    private static class Consumer implements Runnable {

        Producer producer;

        public Consumer() {
        }

        public void setProducer(Producer producer) {
            this.producer = producer;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    synchronized (this) {
                        while (producer.meal == null) {
                            wait();
                        }
                    }

                    synchronized (producer) {
                        System.out.println(producer.meal);
                        producer.meal = null;
                        TimeUnit.SECONDS.sleep(1);
                        producer.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Consumer interrupted");
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec =  Executors.newCachedThreadPool();
        Consumer consumer = new Consumer();
        Producer producer = new Producer(consumer);
        consumer.setProducer(producer);

        exec.execute(consumer);
        exec.execute(producer);

        try {
            TimeUnit.SECONDS.sleep(20);
            exec.shutdownNow();
        } catch (InterruptedException e) {}
    }
}
