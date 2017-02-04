package book;

import java.util.concurrent.TimeUnit;

/**
 * Created by belows on 2017/1/6.
 */
public class Test {
    private static class T1 {
        private String name;

        public T1(String name) {
            this.name = name;
        }

        synchronized void test(String name) {
            while (true)
                System.out.println(name + "......");
        }
    }

    private static class Task implements Runnable {
        public static volatile boolean iscancel = false;

        @Override
        public void run() {
            while (!iscancel) {
                System.out.println("working...");
            }
            System.out.println("finishing...");
        }
    }

    public static void main(String[] args) {

//        T1 t1 = new T1("Test1");
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                t1.test("Test1");
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                t1.test("Test2");
//            }
//        }).start();

//        new Thread(new Task()).start();
//        try {
//            TimeUnit.SECONDS.sleep(1);
//            Task.iscancel = true;
//        } catch (Exception e) {}
        System.out.println(String.format("%.3f",0.2f));
    }
}
