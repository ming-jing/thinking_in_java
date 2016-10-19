/**
 * Created by beta on 16-10-1.
 */
class C1 {
    C1(int i) {
        System.out.println("c1 create");
    }

    void dispose() {
        System.out.println("c1 dispose");
    }
}

class C2 {
    C2(int k) {
        System.out.println("c2 create");
    }

    void dispose() {
        System.out.println("c2 dispose");
    }
}

class C3 {
    C3(int i) {
        System.out.println("c3 create");
    }

    void dispose() {
        System.out.println("c3 dispose");
    }
}

class Root {
    C1 c1 = new C1(1);
    C2 c2 = new C2(2);
    C3 c3 = new C3(3);

    Root(int k) {
        System.out.println("root create");
    }

    void dispose() {
        System.out.println("root dispose");
        c1.dispose();
        c2.dispose();
        c3.dispose();
    }
}

class Stem extends Root {
    C1 c1 = new C1(1);
    C2 c2 = new C2(2);
    C3 c3 = new C3(3);

    Stem(int m) {
        super(m);
        System.out.println("stem create");
    }

    void dispose() {
        System.out.println("stem dispose");
        c1.dispose();
        c2.dispose();
        c3.dispose();
        super.dispose();
    }
}

public class Ex9 {
    public static void main(String[] args) {
        new Stem(7).dispose();
    }
}
