package ex;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by belows on 2017/1/4.
 */
public class Ex9 {

    private static class PriorityThreadFactory implements ThreadFactory {

        private int level = Thread.NORM_PRIORITY;

        public PriorityThreadFactory() {}

        public PriorityThreadFactory(int level) {
            this.level = level;
        }

        public void setPriority(int level) {
            this.level = level;
        }

        @Override
        public Thread newThread(@NotNull Runnable r) {
            Thread t = new Thread(r);
            t.setPriority(level);
            return t;
        }
    }

    private static class Task implements Runnable {

        private volatile double d;

        @Override
        public void run() {
            while(true) {
                // An expensive, interruptable operation:
                for(int i = 1; i < 100000; i++) {
//                    for (int j=0; j<200; ++j) {
                        d += (Math.PI + Math.E) / (double) i;
//                    }
                    if(i % 1000 == 0)
                        Thread.yield();
                }
                System.out.println(Thread.currentThread().toString());
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService maxExe = Executors.newCachedThreadPool(new PriorityThreadFactory(Thread.MAX_PRIORITY));
        ExecutorService minExe = Executors.newCachedThreadPool(new PriorityThreadFactory(Thread.MIN_PRIORITY));

        for (int i=0; i<3; ++i) {
            maxExe.execute(new Task());
        }

        for (int i=0; i<10; ++i) {
            minExe.execute(new Task());
        }
    }
}
