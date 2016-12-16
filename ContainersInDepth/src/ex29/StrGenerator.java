package ex29;

import java.util.Random;

/**
 * Created by belows on 2016/12/14.
 */
public class StrGenerator {

    public static char [] abs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    public static Random rand = new Random(47);

    public static String create(int len) {
        char[] cs = new char[len];
        for (int i=0; i<len; ++i) {
            cs[i] = abs[rand.nextInt(abs.length)];
        }
        return new String(cs);
    }
}
