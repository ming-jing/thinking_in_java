package book;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by belows on 2017/1/4.
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    public int next() {
        ++currentEvenValue; // Danger point here!
        ++currentEvenValue;
        return currentEvenValue;
    }
    public static void main(String[] args) {
//        EvenChecker.test(new EvenGenerator());
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        list.remove((Integer)0);
    }
}
