package ex;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by belows on 2017/1/4.
 */
public class Ex8 {

    private static class Task implements Runnable {

        private static int k = 0;
        private final int id = ++k;

        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                    System.out.println("task " + id + " working...");
                } catch (Exception e) {}
            }
        }
    }

    public static void main(String[] args) {
        List<Thread> ts = new ArrayList<>();

//        for (int i=0; i<1; ++i) {
//            Thread t = new Thread(new Task());
//            t.setDaemon(true);
//            ts.add(t);
//        }
//        for (Thread t : ts) {
//            t.start();
//        }
        Thread t = new Thread(new Task());
        t.setDaemon( true);
        t.start();
    }
}
