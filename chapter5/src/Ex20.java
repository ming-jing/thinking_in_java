/**
 * Created by beta on 16-10-1.
 */
public class Ex20 {
    static void f(int i, Object... args) {
    }

    static void f(Object... args) {
    }

    public static void main(String... args) {
        for (String s : args) {
            System.out.println(s);
        }
//        f(3,4,5);
    }
}
