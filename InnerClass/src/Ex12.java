/**
 * Created by belows on 2016/10/24.
 */

class Outer12 {

    private String s;

    private void outF() {
        System.out.println(s);
    }

    public void outF2() {
        new Inner(){
            @Override
            public void test() {
                s = "Inner test";
                outF();
            }
        }.test();
    }

    abstract class Inner {
        abstract public void test();
    }
}

public class Ex12 {
    public static void main(String[] args) {
        new Outer12().outF2();
    }
}
