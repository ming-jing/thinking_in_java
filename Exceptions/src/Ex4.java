/**
 * Created by belows on 2016/11/1.
 */
class MyException extends Exception {
    String msg;
    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
        msg = message;
    }
}

public class Ex4 {
    public static void main(String[] args) {
        MyException e = new MyException("Test 1");
        System.out.println(e.msg);

        try {
            throw new MyException("test custom exception");
        }catch (MyException e1) {
            System.out.println(e1.msg);
        }
    }
}
