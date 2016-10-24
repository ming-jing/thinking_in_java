/**
 * Created by belows on 2016/10/20.
 */

interface I11 {
    void test();
}

class Adapter11 {

    I11 instance = new Impl();


    private class Impl implements I11 {
        @Override
        public void test() {

        }
    }

    public I11 getInstance() {
        int i = 3;
        class Impl2 implements I11 {
            @Override
            public void test() {
                int j = i;
            }
        }
        return instance;
    }
}

public class Ex11 {

    public static void main(String[] args) {
        I11 i = new Adapter11().getInstance();
//        Adapter11.Impl
    }
}
