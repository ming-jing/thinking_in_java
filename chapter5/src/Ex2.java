/**
 * Created by beta on 16-9-26.
 */
class Base {
    int i = -10;
    int j;
    static int w = 3;

    {
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
    static final int k = 3;

    static {
        System.out.println("T static init, k:" + k);
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
        new T();
    }
}
