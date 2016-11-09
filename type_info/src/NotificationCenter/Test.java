package NotificationCenter;

/**
 * Created by belows on 2016/11/9.
 */
public class Test {

    interface IT {
        void test();
    }

    interface I2 {
        void test2();
    }
    public static class Observer implements IT,I2 {
        String name;

        @Override
        public void test2() {
            System.out.println("I2 test " + name);
        }

        public Observer(String name) {
            this.name = name;
        }

        public void test() {
            System.out.println("observer " + name);
        }
    }

    public static void main(String[] args) {
        Observer o = null;
        for (int i=0; i<5; ++i) {
            Observer observer = new Observer("Test" + i);
            if (i ==3 ) {
                o = observer;
            }
            NotificationCenter.INSTANCE.addObserver(observer);
        }

        NotificationCenter.INSTANCE.removeObserver(o);
        NotificationCenter.INSTANCE.getObserver(IT.class).test();

        NotificationCenter.INSTANCE.getObserver(I2.class).test2();
    }
}
