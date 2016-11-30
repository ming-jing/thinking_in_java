import java.util.*;

/**
 * Created by belows on 2016/11/28.
 */
public class Ex1 {

    private static String[] contries = new String[] {"China","Japan","U.S.A","England","France","Germany"};
    private static List<String> arrayList() {
        return new ArrayList<>(Arrays.asList(contries));
    }

    private static List<String> linkedList() {
        return new LinkedList<>(Arrays.asList(contries));
    }

    public static void main(String[] args) {
        System.out.println(arrayList());
        System.out.println(linkedList());

        List<String> arrayList = arrayList();
        Collections.sort(arrayList);
        System.out.println(arrayList);
        Collections.shuffle(arrayList);
        System.out.println(arrayList);

        List<String> linkList = linkedList();
        Collections.sort(linkList);
        System.out.println(linkList);
        Collections.shuffle(linkList);
        System.out.println(linkList);
    }
}
