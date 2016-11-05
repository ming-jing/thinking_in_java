import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**
 * Created by belows on 2016/11/2.
 */
public class Ex2 {
    static class InfiniteRecursion {
        public String toString() {
            return " InfiniteRecursion address: " + super.toString() + "\n";
        }
        public static void main(String[] args) {
            List<InfiniteRecursion> v =
                    new ArrayList<InfiniteRecursion>();
            for(int i = 0; i < 10; i++)
                v.add(new InfiniteRecursion());
            System.out.println(v);
        }
    }

    public static void main(String[] args) {
//        InfiniteRecursion.main(args);
        String s = "123swe";
        String s1 = new String("123swe").intern();
        System.out.println(s==s1);
    }
}
