import java.util.Arrays;
import java.util.List;
import java.util.Vector;

/**
 * Created by belows on 2016/11/10.
 */
public class Ex11 {
    static class Test<T> {
        T t;
        void display() {
//            System.out.println(t.getClass().getName());
        }
    }

    static void test(Test<String> t) {}

    static class New {
        static <T> Test<T>  test() {
            return new Test<T>();
        }
    }

    public static void main(String[] args) {
        Test<Integer> t = New.test();
        t.display();

        test(New.<String>test());

        Integer[] is = new Integer[] {1,2,3,4,5,6,7,8};
        List<Integer> ls = Arrays.asList(is);
        System.out.println(ls);

        is[3] = 78;
        System.out.println(ls);

        System.out.println(int[].class);
        System.out.println(Integer[].class);
    }
}
