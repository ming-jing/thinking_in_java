import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by belows on 2016/10/25.
 */

class T7 {
    int i ;
    T7(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "T7"+i;
    }
}

public class Ex7 {
    public static void main(String[] args) {
        T7[] ts = new T7[10];
        for (int i=0; i<10; ++i) {
            ts[i] = new T7(i);
        }
        ArrayList<T7> ta = new ArrayList<T7>(Arrays.asList(ts));
        System.out.println(ta);
        List<T7> suba = ta.subList(0,3);
        ta.removeAll(suba);
//        System.out.println(suba);
        System.out.println(ta);
    }
}
