/**
 * Created by beta on 16-10-1.
 */
class StaticTest {
    static String s1 = "Test1";
    static String s2;

    static {
        s2 = "Test2";
    }

    static void test() {
        System.out.println(s1);
        System.out.println(s2);
    }
}

public class Ex14 {
    public static void main(String[] args) {
        StaticTest.test();
    }
}
