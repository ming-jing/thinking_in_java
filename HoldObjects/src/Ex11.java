import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by belows on 2016/10/25.
 */

public class Ex11 {

    public static void display(Collection c) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {
        Collection<Calendar> ca = new ArrayList<>();
        for (int i=0; i<3; ++i) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH,i);
            ca.add(calendar);
        }
        display(ca);

        Collection<Calendar> ta = ca;
        ca = new LinkedList<>();
        ca.addAll(ta);
        display(ca);

        ta = ca;
        ca = new HashSet<>();
        ca.addAll(ta);
        display(ca);

        ta = ca;
        ca = new LinkedList<>();
        ca.addAll(ta);
        display(ca);

        ta = ca;
        ca = new TreeSet<>();
        ca.addAll(ta);
        display(ca);

        ta = ca;
        ca = new LinkedBlockingQueue<>();
        ca.addAll(ta);
        display(ca);
    }
}
