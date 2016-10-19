/**
 * Created by beta on 16-9-28.
 */

class B {
    static int i = -1;

    static {
        System.out.println("B static init i: " + i);
    }

    int j = -3;

    {
        System.out.println("B init j : " + j);
    }

    B() {
        System.out.println("B constructor init");
    }
}

class C extends B {
    static int k = -3;

    static {
        System.out.println("C static init k:" + k);
    }

    int m = -5;

    {
        System.out.println("C init m:" + m);
    }

    C() {
        System.out.println("C constructor init");
    }
}

public class Test {
    public static void main(String[] args) {
        new C();
    }
}
