/**
 * Created by beta on 16-9-28.
 */
public class Ex8 {
    void test1() {

    }

    void test2() {
        test1();
        this.test1();
    }

    public static void main(String[] args) {
        new Ex8().test2();
    }
}
