/**
 * Created by belows on 2016/11/9.
 */
public class Ex2 {
    public static class T {}

    public static class Holder<E> {
        E e1;
        E e2;
        E e3;

        public void setE1(E e1) {
            this.e1 = e1;
        }

        public void setE2(E e2) {
            this.e2 = e2;
        }

        public void setE3(E e3) {
            this.e3 = e3;
        }

        public E getE1() {

            return e1;
        }

        public E getE2() {
            return e2;
        }

        public E getE3() {
            return e3;
        }
    }

    public static void main(String[] args) {
        Holder<T> ts = new Holder<>();
        ts.setE1(new T());
        ts.setE2(new T());
        ts.setE3(new T());
        ts.getE1();
        ts.getE2();
        ts.getE3();
    }
}
