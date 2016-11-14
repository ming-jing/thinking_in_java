/**
 * Created by belows on 2016/11/10.
 */
public class Erased<T> {
    private static final int SIZE = 100;
    public  void f(Object arg) {
//        if(arg instanceof T) {}
//        T var = new T();
//        T[] array = new T[SIZE];
        T[] array = (T[])new Object[SIZE]; // Unchecked warning
    }
}
