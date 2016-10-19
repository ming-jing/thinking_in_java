/**
 * Created by beta on 16-10-1.
 */
class Test17 {
    Test17(String s) {
        System.out.println(s);
    }

    static void test(Object... args) {
        for (Object obj : args) {
            System.out.println(obj);
        }
    }
}

public class Ex17 {
    public static void main(String[] args) {
        Test17[] ts = new Test17[32];
        int i = 0;
        for (Test17 t : ts) {
            t = new Test17("test" + i++);
        }
        Test17.test(ts, 17);
    }
}
