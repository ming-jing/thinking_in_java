import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by belows on 2016/11/29.
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        for (int i=0; i<10; ++i) {
            list.add("Test" + i);
        }
//        List<String> l1 = new ArrayList<>();
//        l1.add("Test0");
//        l1.add("Test20");
//        list.retainAll(l1);
        System.out.println(list);
        String[] s1 = list.toArray(new String[0]);
        s1[0] = "newTest0";
        System.out.println(list);
        System.out.println(Arrays.toString(s1));
        Collections.max(list);
    }
}
