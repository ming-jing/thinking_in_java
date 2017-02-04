package ex;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by belows on 2017/1/4.
 */
public class Ex5 {

    private static class Task implements Callable<Long> {

        private int n;

        public Task(int n) {
            this.n = n;
        }

        @Override
        public Long call() throws Exception {
            if (n == 1 || n==2) {
                return 1l;
            }
            long n1 = 1, n2 = 1, r = 0;
            for (int i=2; i<n; ++i) {
                r = n1 +n2;
                n1 = n2;
                n2 = r;
            }
            return r;
        }
    }

    public static void main(String[] args) throws InterruptedException,ExecutionException {

        ExecutorService exec = Executors.newCachedThreadPool();
        Random random = new Random(System.currentTimeMillis());

        for (int i=0; i<10; ++i) {
            int n = random.nextInt(30) + 30;
           Future<Long> r = exec.submit(new Task(n));
            System.out.println(n + "->" + r.get());
        }
    }
}
