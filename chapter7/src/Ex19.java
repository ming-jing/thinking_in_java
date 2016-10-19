/**
 * Created by beta on 16-10-2.
 */
class Test19 {
    final String s;

    public Test19() {
        s = "1111";
    }

    public Test19(String s) {
        this.s = s;
    }

    void test(int i) {
    }
}

public class Ex19 {
    void test(Test19 t19) {
        t19.test(3);
    }
}
