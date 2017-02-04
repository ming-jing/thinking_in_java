package book;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by belows on 2017/1/16.
 */

class Meal2 {
    private static int sNumber = 1;
    private final int number;
    public boolean finish = false;

    public Meal2() {
        number = sNumber++;
    }

    public synchronized void waitMeal() {
        try {
            wait();
        } catch (InterruptedException e) {}
    }

    public synchronized void notifyMeal() {
        notifyAll();
    }

    @Override
    public String toString() {
        return "Meal order " + number;
    }
}


class WaitPerson2 implements Runnable {

    public WaitPerson2() {
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {

        }
    }
}

class Chef2 implements Runnable{

    public Chef2() {

    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {

        }
    }
}

public class Restaurant2 {
    public static Meal2 meal2 = new Meal2();

    public static void main(String[] args) {

    }
}
