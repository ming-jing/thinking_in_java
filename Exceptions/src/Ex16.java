/**
 * Created by belows on 2016/11/1.
 */

public class Ex16 {
    static class Exception1 extends Exception {}

    static void test(int i) {
        try {
            switch (i) {
                case 0:
                    return;
                case 1:
                    return;
                case 2:
                    return;
                case 3:
                    return;
            }
        } finally {
            System.out.println("finally called");
        }
    }
    public static void main(String[] args) {
        for (int i=0; i<10; ++i) {
            test(i);
        }
    }
}
