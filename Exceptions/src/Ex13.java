/**
 * Created by belows on 2016/11/1.
 */
public class Ex13 {
    static class Exception1 extends Exception {

    }

    static class Exception2 extends Exception {

    }

    static class Exception3 extends Exception {

    }

    static void test() throws Exception1, Exception2, Exception3 {
        int i = 0;
        if (i > 0) {
            throw new Exception1();
        } else if (i == 0) {
            throw new Exception2();
        } else {
            throw new Exception3();
        }
    }

    public static void main(String[] args) {
        try {
            test();
            throw new NullPointerException();
        } catch (Exception e) {
        } finally {
            System.out.println("finally called");
        }

        throw new RuntimeException();
    }
}
