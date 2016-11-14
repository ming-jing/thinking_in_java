/**
 * Created by belows on 2016/11/11.
 */
public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generator<Integer>[] gia;
//    @SuppressWarnings("unchecked")
//    public static void main(String[] args) {
//        // Compiles; produces ClassCastException:
//        gia = (Generator<Integer>[])new Object[SIZE];
//        // Runtime type is the raw (erased) type:
//        gia = (Generator<Integer>[])new Generator[SIZE];
//        System.out.println(gia.getClass().getSimpleName());
//        gia[0] = new Fibonacci();
//        //! gia[1] = new Object(); // Compile-time error
//        // Discovers type mismatch at compile time:
//        //! gia[2] = new Generic<Double>();
//    }

//    static class Test {
//        static <T> void test(T t) {
//            System.out.println(t.toString());
//        }
//    }

    static class ObjectHolder {
        private Object obj;
        public Object get() {
            return obj;
        }

        public void set(Object obj) {
            this.obj = obj;
        }
    }

    public static void main(String[] args) {
        ObjectHolder holder = new ObjectHolder();
        holder.set(3);
        int i = (int)holder.get();
        System.out.println(i);

        holder.set("hello world");
        String s = (String) holder.get();
        System.out.println(s);

        //runtime error
        int k = (int) holder.get();
        System.out.println(k);
    }
}
