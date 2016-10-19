import tt.Base4;

/**
 * Created by beta on 16-10-1.
 */
class T4 extends Base4 {
    void test() {
        protectedTest();
    }
}

public class Ex4 {
    public static void main(String... args) {
        Base4 b = new Base4();
//        b.protectedTest();
    }
}
