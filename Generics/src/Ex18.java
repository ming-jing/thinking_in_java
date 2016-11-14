import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Created by belows on 2016/11/10.
 */
public class Ex18 {
    static class Fish {
        private static int count = 0;
        public final long id = ++count;

        @Override
        public String toString() {
            return getClass().getSimpleName()+ " " + id;
        }
    }

    static class BigFish extends Fish {
        private BigFish() {}

        public static Generator<BigFish> generator() {
            return new Generator<BigFish>() {
                @Override
                public BigFish next() {
                    return new BigFish();
                }
            };
        }

    }

    static class LittleFish extends Fish {
        private LittleFish() {}

        public static Generator<LittleFish> generator = new Generator<LittleFish>() {
            @Override
            public LittleFish next() {
                return new LittleFish();
            }
        };
    }

    static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen , int n) {
        for (int i=0; i<n; ++i) {
            coll.add(gen.next());
        }
        return coll;
    }

    static void eat(BigFish bigFish, LittleFish littleFish) {
        System.out.println(bigFish + " eat " + littleFish);
    }

    public static void main(String[] args) {
        List<BigFish> bigFishes = new ArrayList<>();
        fill(bigFishes,BigFish.generator(),10);

        List<LittleFish> littleFishes = new ArrayList<>();
        fill(littleFishes,LittleFish.generator,20);

        Random random  = new Random(47);
        for (LittleFish littleFish : littleFishes) {
            eat(bigFishes.get(random.nextInt(bigFishes.size())),littleFish);
        }
    }
}
