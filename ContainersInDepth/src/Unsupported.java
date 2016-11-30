import java.util.*;

/**
 * Created by belows on 2016/11/29.
 */
public class Unsupported {
    static void test(String msg, List<String> list) {
        System.out.println("--- " + msg + " ---");
        Collection<String> c = list;
        Collection<String> subList = list.subList(1, 8);
        // Copy of the sublist:
        Collection<String> c2 = new ArrayList<>(subList);
        try {
            c.retainAll(c2);
        } catch (Exception e) {
            System.out.println("retainAll(): " + e);
        }
    }

    public static void main(String[] args) {
        List<String> list =
                Arrays.asList("A B C D E F G H I J K L".split(" "));
        test("Modifiable Copy", new ArrayList<String>(list));
        test("Arrays.asList()", list);
        test("unmodifiableList()",
                Collections.unmodifiableList(
                        new ArrayList<String>(list)));
        List<String> s = Collections.unmodifiableList(list);
        s.set(0,"K");
        System.out.println(s);
    }
}
