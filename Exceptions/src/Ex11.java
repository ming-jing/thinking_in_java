/**
 * Created by belows on 2016/11/1.
 */
public class Ex11 {

    static class MyException extends Exception {

    }

    static class NewException extends Exception {

    }

    static void g() throws MyException {
        throw new MyException();
    }

    static void h() {
        try {
            g();
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace();
        }

        h();
//        try {
//            h();
//        } catch (RuntimeException e) {
//            e.printStackTrace();
//        }
    }
}
