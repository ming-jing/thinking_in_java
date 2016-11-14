import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by belows on 2016/11/10.
 */
public class Ex13 {
    static class Generators {
        public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
            for (int i=0; i<n; ++i) {
                coll.add(gen.next());
            }
            return coll;
        }

        public static <T> List<T> fill(List<T> coll, Generator<T> gen, int n) {
            for (int i=0; i<n; ++i) {
                coll.add(gen.next());
            }
            return coll;
        }

        public static <T> LinkedList<T> fill(LinkedList<T> ls, Generator<T> gen, int n) {
            for (int i=0; i<n; ++i) {
                ls.add(gen.next());
            }
            return ls;
        }
    }

    static class Base {}
    static class T extends Base {}
    static class T2 extends T {}

    static void test(Base b) {
        System.out.println("Base invoke");
    }
    static void test(T t) {
        System.out.println("T invoke");
    }

    public static void main(String[] args) {
        LinkedList<Integer> fibs = new LinkedList<>();
        Generators.fill(fibs,new Fibonacci(),12);
        for (int i : fibs) {
            System.out.print(i + " ");
        }
        System.out.println();

        T2 t = new T2();
        test(t);
    }
}
