import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by belows on 2016/11/30.
 */
public class Ex12 {

    public static void getData(Map<String,String> map) {
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object");
        } catch(Exception e) {}
    }

    public static void main(String[] args) {
        Map<String,String> hashMap = new HashMap<>();
        TreeMap<String,String> treeMap = new TreeMap<>();
        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<>();

        getData(hashMap);
        getData(treeMap);
        getData(linkedHashMap);

        System.out.println(hashMap);
        System.out.println(treeMap);
        System.out.println(linkedHashMap);
    }
}
