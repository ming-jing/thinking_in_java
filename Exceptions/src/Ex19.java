/**
 * Created by belows on 2016/11/1.
 */


class VeryImportantException1 extends Exception {
    public String toString() {
        return "A very important exception!";
    } }
class HoHumException1 extends Exception {
    public String toString() {
        return "A trivial exception";
    }
}

class ThirdException1 extends Exception {
    @Override
    public String toString() {
        return "The third exception";
    }
}

class LostMessage1 {
    void f() throws VeryImportantException1 {
        throw new VeryImportantException1();
    }
    void dispose() throws HoHumException1 {
        throw new HoHumException1();
    }
    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            } finally {
                try {
                    lm.dispose();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}

public class Ex19 {
    public static void main(String[] args) {
        LostMessage1.main(args);
    }
}
