import java.util.*;

/**
 * Created by belows on 2016/10/25.
 */
public class Ex19 {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        for (int i =0; i<10; ++i) {
            hashSet.add("Test" +i);
        }
        System.out.println(hashSet);

        LinkedHashSet<String> set = new LinkedHashSet<>();
        for (int i=0;i<10; ++i) {
            set.add("Test" + i);
        }
        System.out.println(set);

        LinkedHashSet<String> s2 =new LinkedHashSet<>();
        String[] ss = hashSet.toArray(new String[0]);
        Arrays.sort(ss);
        s2.addAll(Arrays.asList(ss));


        Collections.reverseOrder();
    }
}
