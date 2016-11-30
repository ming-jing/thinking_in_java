import java.util.Random;
import java.util.TreeSet;

/**
 * Created by belows on 2016/11/29.
 */
public class Ex9 {

    private static String css = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static char[] cs;
    static {
        cs = new char[css.length()];
        cs = css.toCharArray();
    }

    static Random random = new Random(47);

    private static class RandomGenerator {
        public static String gen(int len) {
            char[] cs =new char[len];
            for (int i=0; i<len; ++i) {
                char c = Ex9.cs[random.nextInt(css.length())];
                cs[i] = c;
            }
            return new String(cs);
        }
    }

    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();
        for (int i=0; i<10; ++i) {
            String s = RandomGenerator.gen(random.nextInt(i+1) + 2);
            ts.add(s);
        }
        System.out.println(ts);
    }
}
