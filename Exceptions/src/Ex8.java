/**
 * Created by belows on 2016/11/1.
 */
public class Ex8 {
    static class MyException extends Exception {
        String msg;
        public MyException() {
            super();
        }

        public MyException(String message) {
            super(message);
            msg = message;
        }
    }

    public static void test() throws MyException {
        throw new MyException("Test");
    }
    public static void main(String[] args) {
        try {
            test();
        } catch (MyException e) {

        }
    }
}
