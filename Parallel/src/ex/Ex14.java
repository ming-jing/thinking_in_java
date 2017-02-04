package ex;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by belows on 2017/1/8.
 */
public class Ex14 {
    private static final int size =20;
    public static void main(String[] args) {
        for (int i=0; i<size; ++i) {
            test(i);
        }
    }

    private static void test(int i) {
        Random random = new Random();
        Timer timer = new Timer("test" + i,true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Test" +i + " working...");
            }
        },random.nextInt(10)*1000);
    }
}
