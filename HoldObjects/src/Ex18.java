import java.util.*;

/**
 * Created by belows on 2016/10/25.
 */
public class Ex18 {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0; i<5; ++i) {
            map.put(i*2,i*3);
        }
        for (int i=1; i<5; ++i) {
            map.put(i*2-1,(i*2-1) *3);
        }
        System.out.println(map);

        ArrayList<String> list = new ArrayList<>();
        list.toArray(new String[10]);
        Integer[] is = map.keySet().toArray(new Integer[0]);
        Arrays.sort(is);
        LinkedHashMap<Integer,Integer> m2 = new LinkedHashMap<>();
        for (int i : is) {
            System.out.print(map.get(i) + " ");
            m2.put(i,map.get(i));
        }
        System.out.println();
        System.out.println(m2);
    }
}
