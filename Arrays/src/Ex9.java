import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by belows on 2016/11/21.
 */
public class Ex9 {
    static class Banana {
        private static int count = 0;
        public final int id = ++count;

        @Override
        public String toString() {
            return getClass().getSimpleName() + ",id:" + id;
        }
    }

    static class Peel<T> {
        T fruit;
        Peel(T fruit) {
            this.fruit = fruit;
        }

        @Override
        public String toString() {
            return "Peeling " + fruit;
        }
    }

    public static void main(String[] args) {
        Peel<Banana>[] pa = new Peel[9];
        for (int i=0; i<pa.length;++i) {
            pa[i] = new Peel<>(new Banana());
        }
        System.out.println(Arrays.toString(pa));

        ArrayList<Peel<Banana>> ps = new ArrayList<>(9);
        for (int i=0; i<9; ++i) {
            ps.add(new Peel<>(new Banana()));
        }
        System.out.println(ps);
    }
}
