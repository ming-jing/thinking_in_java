/**
 * Created by belows on 2016/10/20.
 */

class Outer7 {

    private String s;

    private void outF() {
        System.out.println(s);
    }

    public void outF2() {
        Inner inner = new Inner();
        inner.test();
    }

    class Inner {
        public void test() {
            s = "inner string";
            outF();
        }
    }
}

public class Ex7 {
    public static void main(String[] s) {
        new Outer7().outF2();
    }
}
