package book;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by belows on 2017/1/6.
 */
public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " +
                    captured);
        } finally {
            if (captured)
                lock.unlock();
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed(); // True -- lock is available
        al.timed();   // True -- lock is available
        // Now create a separate task to grab the lock:
        new Thread() {
            {
                setDaemon(true);
            }

            public void run() {
                try {
                    al.lock.lock();
                    System.out.println("acquired");
                    TimeUnit.SECONDS.sleep(25500);
                } catch (Exception e) {
                } finally {
                    System.out.println("finally");
                    al.lock.unlock();
                }
            }
        }.start();
        try {
            TimeUnit.SECONDS.sleep(1);
//            Thread.yield(); // Give the 2nd task a chance
            al.untimed(); // False -- lock grabbed by task
            al.timed();   // False -- lock grabbed by task
        } catch (Exception e) {
        }
    }
}