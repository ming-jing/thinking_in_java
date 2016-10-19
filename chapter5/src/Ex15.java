/**
 * Created by beta on 16-10-1.
 */

class Test15 {
    String s, s2;
    int[] a1, a2;

    {
        s = "Test15";
    }

    int[] ts = new int[]{5};

    static void test(String[] args) {
    }
}

public class Ex15 {
    public static void main(String[] args) {
        Test15 t = new Test15();
        System.out.println(t.s + t.s2);
        System.out.println(t.a1);
        System.out.println(t.a2);

        Test15[] ts = new Test15[32];
        ts = new Test15[]{new Test15(),};
        Test15.test(new String[]{"ssss"});
    }
}
