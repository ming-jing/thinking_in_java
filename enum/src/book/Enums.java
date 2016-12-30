package book;

import java.util.Random;

/**
 * Created by belows on 2016/12/27.
 */
public class Enums {

    private static Random random = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> cls) {
        return random(cls.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[random.nextInt(values.length)];
    }
}
