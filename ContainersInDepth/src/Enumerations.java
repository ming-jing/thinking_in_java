import ex29.StrGenerator;

import java.util.*;

/**
 * Created by belows on 2016/12/16.
 */
public class Enumerations {
    public static void main(String[] args) {
        Vector<String> v =
                new Vector<String>(list(10));
        Enumeration<String> e = v.elements();
        while(e.hasMoreElements())
            System.out.println(e.nextElement() + ", ");
        // Produce an Enumeration from a Collection:
        e = Collections.enumeration(list(10));
        while(e.hasMoreElements())
            System.out.print(e.nextElement() + ", ");

    }

    private static List<String> list(int size) {
        List<String> list = new ArrayList<>();
        for(int i=0; i<size; ++i) {
            list.add(StrGenerator.create(5));
        }
        return list;
    }
}
