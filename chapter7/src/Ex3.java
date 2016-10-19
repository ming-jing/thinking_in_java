/**
 * Created by beta on 16-10-1.
 */
class Test3 extends Base3 {
    Test3() {
        System.out.println("Test3 init");
    }
}

class Base3 {
    Base3() {
        System.out.println("Base3 init");
    }
}

public class Ex3 {
    public static void main(String[] args) {
        new Test3();
    }
}
