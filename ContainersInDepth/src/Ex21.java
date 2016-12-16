/**
 * Created by belows on 2016/12/6.
 */
public class Ex21 {
    public static void main(String[] args) {
        SimpleHashMap<String,Integer> map = new SimpleHashMap<>();

        for (int i=0; i<4096; ++i) {
            map.put("Test" + i,i);
        }

        map.get("Test"+224);


        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
