package ex;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by belows on 2017/1/4.
 */
public class Ex4 {
    private static class Task implements Runnable {

        int n = 0;
        private static int k = 0;
        private final int id = ++k;

        public Task(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            System.out.println("Task" +id +",result:" + count(n));
        }

        private long count(int n) {
            if (n==1 || n==2) {
                return 1;
            }

            long n1=1,n2=1,r=0;
            for (int i=2; i<n; ++i) {
                r = n1 + n2;
                n1= n2;
                n2 = r;
            }
            return r;
        }
    }

    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());
        ExecutorService exec = Executors.newSingleThreadExecutor();//.newCachedThreadPool();
        for (int i=0; i<10; ++i) {
//            new Thread(new Task(random.nextInt(30) + 30)).start();
            exec.execute(new Task(random.nextInt(30)+30));
        }
    }
}
