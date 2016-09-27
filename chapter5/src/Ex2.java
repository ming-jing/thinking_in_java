/**
 * Created by beta on 16-9-26.
 */
class Base {
    int i = -10;
    int j;
    static int w = 3;

    static {
        w = 5;
        System.out.println("base static init, w:" + w);
    }

    {
        System.out.println("base init i:" + i + ",j:" + j);
    }

    Base() {
        int j = -5;
        System.out.println("base constructor init i:" + i + ",j:" + j);
    }
}

class T extends Base {
    int m = -10;
    int n;
    static char c;
    static int k = 3;
    static final String s = getS();

    static void test() {
    }

    static {
        System.out.println("T static init, k:" + k);
    }

    private static String getS() {
        return "ssss";
    }

    {
        System.out.println("t init m:" + m + ",n:" + n);
    }

    T() {
        int j = -5;
        System.out.println("i init constructor init m:" + m + ",n:" + n);
    }
}

public class Ex2 {
    public static void main(String[] args) {
//        System.out.println(T.k);
//        T.test();
        new T();
    }
}
