import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

/**
 * Created by belows on 2016/11/29.
 */
public class Ex6 {

    static void test(List<String> list) {
        list.add("Test0");
        list.remove("Test0");
        List<String> l1 =
                Arrays.asList("1 2 3 4 5 6 7 8 9".split(" "));
        list.addAll(l1);
        list.addAll(3,l1);
        list.retainAll(l1);
        list.removeAll(l1);
        list.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                if (s.equals("Test0")) {
                    return "3333";
                }
                return s;
            }
        });
        list.clear();
        list.add(0,"Test4");
        list.set(0,"Test4");
        list.remove("Test4");

    }

    public static void main(String[] args) {
        List<String> list =
                Arrays.asList("A B C D E F G H I J K L".split(" "));
        ArrayList arrayList = new ArrayList(list);
        test(arrayList);

        arrayList.add("Test0");
        arrayList.add("Test0");
        arrayList.add("Test0");
        System.out.println(arrayList);
    }
}
