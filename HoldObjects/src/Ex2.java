import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by belows on 2016/10/25.
 */


public class Ex2 {
    public static void main(String[] args) {
        Collection<Integer> cs = new HashSet<>();
        for (int i=0; i<10; ++i) {
            cs.add(i);
            cs.add(i);
        }
        for (int i : cs ) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
