import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by belows on 2016/11/9.
 */
public class Ex6 {

    static class RandomList<T> {
        List<T> list = new ArrayList<T>();
        Random random = new Random(47);

        public void add(T t) {
            list.add(t);
        }

        public T select() {
            int index = random.nextInt(list.size());
            return list.get(index);
        }

    }
    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<String>();
        for(String s: ("The quick brown fox jumped over " +
                "the lazy brown dog").split(" "))
            rs.add(s);

        for (int i=0; i<11; ++i) {
            System.out.print(rs.select() + " ");
        }
        System.out.println();

        RandomList<Integer> ri = new RandomList<>();
        for (int i=0; i<20; ++i) {
            ri.add(i);
        }
        for (int i=0; i<11; ++i) {
            System.out.println(ri.select() + " ");
        }
        System.out.println();

    }
}
