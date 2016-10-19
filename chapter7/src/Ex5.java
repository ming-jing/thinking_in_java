/**
 * Created by beta on 16-10-1.
 */
class A {
    A(int k) {
        System.out.println("A create");
    }
}

class B {
    B(int m) {
        System.out.println("B create");
    }
}

class C extends A {
    B b;

    C() {
        super(3);
        b = new B(5);
    }
}

public class Ex5 {
    public static void main(String[] args) {
        new C();
    }
}
