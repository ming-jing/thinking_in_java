package ex;

import java.util.*;

/**
 * Created by belows on 2016/12/27.
 */
public class Ex2 {
    enum CartoonCharacter {
        SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
        static Random random = new Random(47);
        static CartoonCharacter next() {
            return values()[random.nextInt(values().length)];
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<10; ++i) {
            System.out.print(CartoonCharacter.next() + " ");
        }
        List<String> list = new ArrayList<>(null);
        System.out.println(list);
    }
}
