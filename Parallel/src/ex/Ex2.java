package ex;

import java.util.Random;

/**
 * Created by belows on 2017/1/4.
 */
public class Ex2 {
    private static class Task implements Runnable {

        private int n;
        private static int k = 0;
        private final int id;

        public Task(int n) {
            this.n = n;
            id = ++k;
        }

        @Override
        public void run() {
            System.out.println("task " + id + " result:" + count(n));
        }

        private long count(int n) {
//            if (n==1 || n==2)
//                return 1;
//            return count(n-1) + count(n-2);
            if (n==1 || n==2)
                return 1;
            long n1=1,n2=1;
            long r = 0;
            for (int i=2;i<n; ++i) {
                r = n1 + n2;
                n1 = n2;
                n2 = r;
            }
            return r;
        }
    }

    public static void main(String[] args) {
        Random random = new Random(System.currentTimeMillis());
        for (int i=0; i<5; ++i) {
            new Thread(new Task(random.nextInt(80) + 10)).start();
        }

//        for (int i=0; i<30; ++i) {
//            int n = random.nextInt(30) + 10;
//            int r1 = count1(n);
//            int r2 = count2(n);
//            System.out.println(r1==r2);
//        }
    }

    private static int count1(int n) {
        if (n==1 || n==2) {
            return 1;
        }
        return count1(n-1) + count1(n-2);
    }

    private static int count2(int n) {
        if (n==1 || n==2) {
            return 1;
        }
        int n1=1,n2=1,r=0;

        for (int i=2;i<n; ++i) {
            r = n1 + n2;
            n1 = n2;
            n2 =r;
        }
        return r;
    }
}
