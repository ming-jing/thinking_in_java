package book;

/**
 * Created by belows on 2017/1/4.
 */
public class SelfManaged implements Runnable {
    private int countDown = 5;
    private Thread t = new Thread(this);

    public SelfManaged() {
        t.start();
    }

    public String toString() {
        return Thread.currentThread().getName() +
                "(" + countDown + "), ";
    }

    public void run() {
        while (true) {
            System.out.print(this);
            if (--countDown == 0)
                return;
        }
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++)
//            new SelfManaged();
        for (int i=0; i<5; ++i) {
            new Thread(new CustomThread()).start();
        }
    }

    private static class CustomThread extends Thread implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.print(this);
                return;
            }
        }
    }
}
