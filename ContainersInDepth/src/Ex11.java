import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by belows on 2016/11/30.
 */
public class Ex11 {

    private static class Test implements Comparable<Test> {
        Integer i;
        static Random random = new Random(47);

        public Test() {
            i = random.nextInt(100);
        }

        @Override
        public int compareTo(@NotNull Test t) {
            if (i < t.i) {
                return -1;
            } else if (i == t.i) {
                return 0;
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "Test" + i;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Test> ps = new PriorityQueue<>();
        for (int i=0; i<15; ++i) {
            ps.add(new Test());
        }
//        Iterator<Test> it = ps.iterator();
//        while (it.hasNext()) {
//            Test t = it.next();
//            System.out.print(t + " ");
//        }
//        System.out.println();
        while (!ps.isEmpty()) {
            System.out.println(ps.poll());
        }
    }
}
