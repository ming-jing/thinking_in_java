import java.util.*;

/**
 * Created by belows on 2016/11/28.
 */
public class Ex3 {

    private static List<String> list() {
        List<String> list = new ArrayList<>();
        for (int i=0,size=Contries.contries.length; i<size; ++i ) {
            list.add(Contries.contries[i][0]);
        }
        return list;
    }

    private static void fill(Set<String> cs) {
        cs.addAll(list());
        cs.addAll(list());
        cs.addAll(list());
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        fill(set);
        System.out.println(set);

        LinkedHashSet<String> ls = new LinkedHashSet<>();
        fill(ls);
        System.out.println(ls);

        TreeSet<String> ts = new TreeSet<>();
        fill(ts);
        System.out.println(ts);
    }
}
