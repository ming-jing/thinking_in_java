/**
 * Created by belows on 2016/11/1.
 */

class VeryImportantException extends Exception {
    public String toString() {
        return "A very important exception!";
    } }
class HoHumException extends Exception {
    public String toString() {
        return "A trivial exception";
    }
}

class ThirdException extends Exception {
    @Override
    public String toString() {
        return "The third exception";
    }
}

class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException {
        throw new HoHumException();
    }

    void test() throws ThirdException {
        throw new ThirdException();
    }

    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                try {
                    lm.f();
                } finally {
                    lm.dispose();
                }
            } finally {
                lm.test();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

public class Ex18 {

    public static void main(String[] args) {
        LostMessage.main(args);
    }
}
