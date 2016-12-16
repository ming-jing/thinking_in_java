import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Random;

/**
 * Created by belows on 2016/12/15.
 */
public class Ex41 {
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
        public int hashCode() {
            return first.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Test)) {
                return false;
            }
            return ((Test) obj).first.equals(first);
        }

        @Override
        public int compareTo(@NotNull Test other) {
            return first.compareToIgnoreCase(other.first);
        }
    }

    public static void main(String[] args) {
        HashSet<Test> set = new HashSet<>();
        for (int i=0; i<10; ++i) {
            set.add(new Test("55555",StrGenerator.create(5)));
        }
        System.out.println(set);
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
