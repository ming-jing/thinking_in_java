/**
 * Created by beta on 16-10-1.
 */
class Test18 {
    static void test(String... args) {
        for (String s : args) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}

public class Ex19 {
    public static void main(String[] args) {
        Test18.test(new String[]{"test1", "test2", "test3"});
        Test18.test("t1", "t2", "t3", "t4");
    }
}
