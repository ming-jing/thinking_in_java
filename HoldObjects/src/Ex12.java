import java.util.*;

/**
 * Created by belows on 2016/10/25.
 */

public class Ex12 {
    public static void main(String[] args) {
        ArrayList<Integer> is1 = new ArrayList<>();
        for (int i=0; i<10; ++i) {
            is1.add(i);
        }
        List<Integer> is2 = new ArrayList<>();
        for(int i=is1.size()-1; i>=0; --i) {
            is2.add(is1.get(i));
        }
        System.out.println(is2);

        is2.clear();
        for (int i=0; i<is1.size(); ++i) {
            is2.add(0,i);
        }
        System.out.println(is2);

        is2.clear();
        for (int i : is1) {
            is2.add(0,i);
        }
        System.out.println(is2);

        is2.clear();
        Iterator<Integer> it = is1.iterator();
        while (it.hasNext()) {
            is2.add(0,it.next());
        }
        System.out.println(is2);

        is2.clear();
        ListIterator<Integer> listIt = is1.listIterator(is1.size());
        while (listIt.hasPrevious()) {
            is2.add(listIt.previous());
        }
        System.out.println(is2);

        LinkedList<String> s = new LinkedList<>();
//        s.add(null);
        System.out.println(s.getFirst());
    }
}
