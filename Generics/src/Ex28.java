import sun.net.www.content.text.Generic;

/**
 * Created by belows on 2016/11/14.
 */
public class Ex28 {

    static class Generic1<T> {
        void test(T t) {}
    }

    static class Generic2<T> {
        T test() {
            return null;
        }
    }

    static <E extends Generic1<? super String>> void gen1Test(E e) {
        String obj = null;
        e.test(obj);
    }

    static <E extends Generic2<? extends String>> String gen2Test(E e) {
        return  e.test();
    }

    public static void main(String[] args) {

    }
}
