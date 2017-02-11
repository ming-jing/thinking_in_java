package ex;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by belows on 2017/2/7.
 */
public class Ex27 {

    static Restaurant restaurant = new Restaurant();

    static class Meal {
        private static int index = 0;
        private final int id = ++index;

        @Override
        public String toString() {
            return "Meal:" + id;
        }
    }

    static class Restaurant {
        Meal meal;

        Restaurant() {

        }
    }

    static class Chef implements Runnable {

        private Lock lock;
        private Condition condition;

        public Chef(Lock lock, Condition condition) {
            this.lock = lock;
            this.condition = condition;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    lock.lock();
                    try {
                       while (restaurant.meal != null) {
                           condition.await();
                       }
                       TimeUnit.MILLISECONDS.sleep(200);
                        restaurant.meal = new Meal();
                        condition.signalAll();
                    } finally {
                        lock.unlock();
                    }
                }
            } catch (InterruptedException e) {}
        }
    }

    static class Waiter implements Runnable {

        private Lock lock;
        private Condition condition;

        public Waiter(Lock lock, Condition condition) {
            this.lock = lock;
            this.condition = condition;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    lock.lock();
                    try {
                        while (restaurant.meal == null) {
                            condition.await();
                        }
                        TimeUnit.MILLISECONDS.sleep(200);
                        System.out.println(restaurant.meal);
                        restaurant.meal = null;
                        condition.signalAll();
                    } finally {
                        lock.unlock();
                    }
                    TimeUnit.MILLISECONDS.sleep(200);
                }
            } catch (InterruptedException e) {}

        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        Chef chef = new Chef(lock,condition);
        Waiter waiter = new Waiter(lock,condition);

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(chef);
        exec.execute(waiter);
    }
}
