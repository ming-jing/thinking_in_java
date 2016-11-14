/**
 * Created by belows on 2016/11/10.
 */
public class Ex14 {
    static class BasicGenerator<T> implements Generator<T> {

        Class<T> tcls;

        public BasicGenerator(Class<T> cls) {
            tcls = cls;
        }

        @Override
        public T next() {
            try {
                return tcls.newInstance();
            } catch (IllegalAccessException e) {
                System.out.println("IllegalAccessException");
            }
            catch (InstantiationException e) {
                System.out.println("InstantiationException");
            }
            return null;
        }

        public static <T> BasicGenerator<T> create(Class<T> type) {
            return new BasicGenerator<T>(type);
        }
    }

    static class CountedObject {
        private static int count = 0;
        public long id = count++;

        @Override
        public String toString() {
            return "CountedObject " + id;
        }
    }

    public static void main(String[] args) {
        BasicGenerator<CountedObject> gen = BasicGenerator.create(CountedObject.class);
        for (int i=0; i<10; ++i) {
            System.out.println(gen.next());
        }
    }
}
