/**
 * Created by beta on 16-10-1.
 */
class Base13 {
    void f() {
    }

    void f(int i) {
    }

    void f(char c) {
    }
}

class Test13 extends Base13 {
    void f(String s) {
    }
}

public class Ex13 {
    public static void main(String[] args) {
        Test13 t = new Test13();
        t.f();
        t.f(1);
        t.f('3');
        t.f("s323r");
    }
}
