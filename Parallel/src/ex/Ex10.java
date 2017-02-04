package ex;

import java.util.concurrent.*;

/**
 * Created by belows on 2017/1/4.
 */
public class Ex10 {

    private static class MethodThread {

        ExecutorService exec;

        public long runTask(final int n) throws InterruptedException,ExecutionException {
            if (exec == null) {
                exec = Executors.newCachedThreadPool();
            }
            Callable<Long> callable = new Callable<Long>() {
                @Override
                public Long call() throws Exception {
                    if (n ==1 || n==2) {
                        return 1l;
                    }
                    long n1=1,n2=1,r=0;
                    for (int i=2;i<n; ++i) {
                        r = n1 + n2;
                        n1 = n2;
                        n2 = r;
                    }
                    return r;
                }
            };
            Future<Long> r = exec.submit(callable);
            return r.get();
        }
    }

    public static void main(String[] args) throws InterruptedException,ExecutionException {
        MethodThread thread = new MethodThread();
        for (int i=0; i<10; ++i) {
            System.out.println(thread.runTask(i+2));
        }
    }
}
