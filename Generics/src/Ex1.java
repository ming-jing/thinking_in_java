/**
 * Created by belows on 2016/11/9.
 */
public class Ex1 {

    static class Base {}
    static class T extends Base {}
    static class Holder<E> {
        E e;

        public void set(E e) {
            this.e = e;
        }

        public E get() {
            return e;
        }
    }

    public static void main(String[] args) {
        Base b = new Base();
        T t = new T();
        Holder<Base> holder = new Holder<>();
        holder.set(b);
        Base b1 = holder.get();

        holder.set(t);
        Base b2 = holder.get();

    }
}
