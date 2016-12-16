import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Created by belows on 2016/12/15.
 */
public class Ex40 {

    private static class Test implements Comparable<Test> {
        String first;
        String second;

        public Test(String first, String second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public String toString() {
            return "first:" +  first + ",second:" + second + "\n";
        }

        @Override
        public int compareTo(@NotNull Test other) {
            return first.compareToIgnoreCase(other.first);
        }
    }

    public static void main(String[] args) {
        Test[] sArray = new Test[10];
        List<Test> tList = new ArrayList<>();

        for (int i=0; i<10; ++i) {
            sArray[i] = new Test(StrGenerator.create(5),StrGenerator.create(5));
            tList.add(sArray[i]);
        }

        Arrays.sort(sArray);
        System.out.println(Arrays.toString(sArray));
        Collections.sort(tList);
        System.out.println(tList);

        Comparator<Test> comparator = new Comparator<Test>() {
            @Override
            public int compare(Test o1, Test o2) {
                return o1.second.compareToIgnoreCase(o2.second);
            }
        };
        Arrays.sort(sArray, comparator);
        System.out.println("\n\n\n" + Arrays.toString(sArray));
        Collections.sort(tList,comparator);
        System.out.println(tList);

    }

    private static class StrGenerator {
        private static Random random = new Random(47);
        private static final char[] cs = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        public static String create(int len) {
            char[] rs = new char[len];
            for (int i=0; i<len; ++i) {
                rs[i] = cs[random.nextInt(cs.length)];
            }
            return new String(rs);
        }
    }
}
