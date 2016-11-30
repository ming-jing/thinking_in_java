/**
 * Created by belows on 2016/11/14.
 */
public class Ex30 {
    static class Holder<T> {

        T t  = null;

        T get() {
            return t;
        }

        void set(T t) {
            this.t = t;
        }
    }

    public static void main(String[] args) {
        Holder<Integer> intHolder = new Holder<>();
        intHolder.set(3);
        int i = intHolder.get();

        Holder<Byte> byteHolder = new Holder<>();
        byteHolder.set((byte)3);
        byte b = byteHolder.get();


    }
}
