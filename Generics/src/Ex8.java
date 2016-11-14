import java.util.Iterator;
import java.util.Random;

/**
 * Created by belows on 2016/11/10.
 */
public class Ex8 {

    static class Guy {
        private static int counter;
        private long id = counter++;

        @Override
        public String toString() {
            return getClass().getName() + " " + id;
        }
    }

    static class GoodGuy extends Guy {
        @Override
        public String toString() {
            return super.toString() + " this is a good guy";
        }
    }
    static class BadGuy extends Guy {
        @Override
        public String toString() {
            return super.toString() + " this is a bad guy";
        }
    }
    static class Morton extends BadGuy {}
    static class Frank extends BadGuy {}
    static class Harmonica extends GoodGuy {}
    static class Cheyenne extends GoodGuy {}

    static class GuyGenerator implements Generator<Guy>,Iterable<Guy> {

        static Class<? extends Guy>[] types = new Class[]{Morton.class,Frank.class,Harmonica.class,Cheyenne.class};
        static Random random = new Random(47);

        @Override
        public Guy next() {
            int index = random.nextInt(types.length);
            try {
                Class<? extends Guy> type = types[index];
                Guy guy = type.newInstance();
                return guy;
            } catch (IllegalAccessException e) {}
            catch (InstantiationException e) {}
            return null;
        }

        int count;
        GuyGenerator(int count) {
            this.count = count;
        }

        @Override
        public Iterator<Guy> iterator() {
            return new Iterator<Guy>() {
                int n = count;
                @Override
                public boolean hasNext() {
                    return n > 0;
                }

                @Override
                public Guy next() {
                    n--;
                    return GuyGenerator.this.next();
                }
            };
        }
    }

    public static void main(String[] args) {
        GuyGenerator generator = new GuyGenerator(11);
        for (int i=0; i<11; ++i) {
            System.out.println(generator.next());
        }

        System.out.println();
        for (Guy guy : generator) {
            System.out.println(guy);
        }
    }
}
