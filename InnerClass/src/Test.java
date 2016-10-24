/**
 * Created by belows on 2016/10/22.
 */
abstract class TTK {
    TTK(){};
    abstract void test();
}
public class Test {
    static int k = 3;

    static void test(int i) {
        new TTK() {
            {
                if (i > 7) {
                    System.out.println("i>7");
                } else {
                    System.out.println("i<=7");
                }
            }
            @Override
            void test() {

            }
        };
    }
    public static void main(String[] args) {
//        new TTK() {
//            {
//                if (k > 5) {
//                    System.out.println("x > 5");
//                } else {
//                    System.out.println("x <= 5");
//                }
//            }
//            @Override
//            public void test() {
//
//            }
//        };
        test(3);
    }
}
