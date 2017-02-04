package ex;

/**
 * Created by belows on 2017/1/4.
 */
public class Ex1 {
    private static class Task implements Runnable {

        private String start;

        public Task(String start) {
            this.start = start;
        }

        @Override
        public void run() {
            System.out.println("task start:" + start);
            for (int i=0; i<3; ++i) {
                System.out.println("task "+ start + "working");
                Thread.yield();
            }
            System.out.println("task "+ start + " end");
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<10; ++i) {
            new Thread(new Task("Test" + i)).start();
        }
    }
}
