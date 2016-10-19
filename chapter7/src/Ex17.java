/**
 * Created by beta on 16-10-2.
 */
class Amphibian {
    void test() {
        System.out.println("base test");
    }
}

class Frog extends Amphibian {
    void test() {
        System.out.println("frog test");
    }
}

public class Ex17 {
    public static void main(String[] args) {
        Amphibian obj = new Frog();
        obj.test();
    }
}
