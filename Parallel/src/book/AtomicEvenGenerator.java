package book;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by belows on 2017/1/8.
 */
public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger currentEvenValue =
            new AtomicInteger(0);
    public int next() {
        return currentEvenValue.addAndGet(2);
    }
    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
