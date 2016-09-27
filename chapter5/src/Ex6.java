/**
 * Created by beta on 16-9-27.
 */
public class Ex6 {
    public void test(int i, String s) {
        System.out.println("int first, i:" + i + ",s:" + s);
    }

    public void test(String s, int i) {
        System.out.println("string first, s:" + s + ",i:" + i);
    }

    public static void main(String[] args) {
        Ex6 ex6 = new Ex6();
        ex6.test(3, "test");
        ex6.test("test", 3);
    }
}
