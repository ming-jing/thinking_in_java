import java.util.*;

/**
 * Created by belows on 2016/11/29.
 */
public class Ex7 {

    private static void print(List<String> ls) {
        Iterator<String> it = ls.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    private static void insert(List<String> l1, List<String> l2) {
        ListIterator<String> it1 = l1.listIterator();
        ListIterator<String> it2 = l2.listIterator();

        while (it1.hasNext()) {
            if (!it2.hasNext()) {
                break;
            }
            String s2 = it2.next();
            it1.add(s2);
            it1.next();
        }
    }

    private static void insert2(List<String> l1, List<String> l2) {
        ListIterator<String> it1 = l1.listIterator(l1.size());
        ListIterator<String> it2 = l2.listIterator(l2.size());

        while (it1.hasPrevious()) {
            if (!it2.hasPrevious()) {
                break;
            }
            String s2 = it2.previous();
            it1.add(s2);
            it1.previous();
        }
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(Contries.contries(5));
        LinkedList<String> linkedList = new LinkedList<>(Contries.contries(5,5));

        print(arrayList);
        print(linkedList);


//        insert(arrayList,linkedList);
//        print(arrayList);

        insert2(arrayList,linkedList);
        print(arrayList);
    }
}