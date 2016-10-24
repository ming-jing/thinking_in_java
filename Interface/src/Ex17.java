/**
 * Created by belows on 2016/10/19.
 */
class inter17 {
    int i = 3;

    private interface it {
        void test();
    }

    public class D implements it {
        @Override
        public void test() {

        }
    }
}

public class Ex17 {
    public static void main(String[] args) {
        inter17.D d = new inter17().new D();
    }
}
