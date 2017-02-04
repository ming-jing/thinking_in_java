package ex;

/**
 * Created by belows on 2017/1/6.
 */
public class Ex11 {
    private static class T {
        private volatile int k;

        public synchronized int getK() {
            return k;
        }

        public synchronized void test() {
            ++k;
            --k;
        }
    }

    public static void main(String[] args) {
        T t = new T();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    t.test();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(t.getK());
                }
            }
        }).start();
    }
}
