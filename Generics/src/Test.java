/**
 * Created by belows on 2016/11/11.
 */
class ObjectHolder<T> {
    private T t = null;
    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    @Override
    public String toString() {
        if (t !=null) {
            return t.toString();
        } else {
            return "null";
        }
    }

    static class Test {
    }
}

public class Test {
    public static void main(String[] args) {
        ObjectHolder<String> strHolder = new ObjectHolder<>();
        strHolder.set("Hello World");
        String s = strHolder.get();

        ObjectHolder<Integer> intHolder = new ObjectHolder<>();
        intHolder.set(3);
        int i = intHolder.get();

        //intHolder.set("Test");//compile error,intHolder只能作用在Integer上
    }
}
