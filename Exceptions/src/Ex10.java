/**
 * Created by belows on 2016/11/1.
 */
public class Ex10 {
    static class MyException extends Exception {

    }

    static class NewException extends Exception {

    }

    static void g() throws MyException {
        throw new MyException();
    }

    static void h() throws Throwable {
        try {
            g();
        }catch (MyException e) {
            throw new NewException().initCause(e);
        }
    }

    public static void main(String[] args) {
        try {
            g();
        }catch (MyException e) {
            e.printStackTrace();
        }

        try {
            h();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
