import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by belows on 2016/11/15.
 */
public class Ex35 {

    static void add(List list) {
        list.add(3);
    }

    public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        add(ls);

        String s = ls.get(0);
        List<String> chs = Collections.checkedList(new ArrayList<>(),String.class);
        try {
            add(chs);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static class T <E extends Throwable> {

    }
}
