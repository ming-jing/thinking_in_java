/**
 * Created by beta on 16-9-4.
 */
public class CountDown {
    public static void main(String[] args) {
        countDown(10);
    }

    private static void countDown(int second) {
        long l = System.currentTimeMillis();
        for (int i = 0; i < second; ++i) {
            try {
                Thread.currentThread().sleep(1000);
            } catch (Exception e) {
            }
        }
        System.out.println((System.currentTimeMillis() - l) / 1000);
    }
}
