/**
 * Created by belows on 2016/11/2.
 */



public class Ex28 {
    static class MyException extends RuntimeException {
        String msg;
        public MyException() {
            super();
        }

        public MyException(String message) {
            super(message);
            msg = message;
        }
    }

    public static void main(String[] args) {
        MyException e = new MyException("Test 1");
        System.out.println(e.msg);

//        try {
//            throw new MyException("test custom exception");
//        }catch (MyException e1) {
//            System.out.println(e1.msg);
//        }
        throw new MyException("test custom exception");
    }
}
