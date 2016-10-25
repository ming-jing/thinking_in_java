/**
 * Created by belows on 2016/10/24.
 */

interface I20 {
    I20 instance = new Impl();

    void test();
    class Impl implements I20 {
        @Override
        public void test() {
            System.out.println("Default test implement");
        }
    }
}

public class Ex20 {
    public static void main(String[] args) {
        I20.instance.test();
    }
}
