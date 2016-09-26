/**
 * Created by beta on 16-9-25.
 */
public class Ex14 {
    public static void main(String[] args) {
        compare("111", "111");
    }

    public static void compare(String s1, String s2) {
        System.out.println("s1==s2," + s1 == s2);
        System.out.println("s1!=s2," + s1 != s2);
        System.out.println("s1 equals s2," + s1.equals(s2));
    }
}
