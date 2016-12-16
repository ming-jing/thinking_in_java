/**
 * Created by belows on 2016/12/6.
 */
public class Ex20 {
    public static void main(String[] args) {
        SimpleHashMap<String,Integer> map = new SimpleHashMap<>();
        for (int i=0; i<20; ++i) {
            map.put("Test" + i, i);
        }
        for (int i=2; i<10; ++i) {
            map.put("Test" + i, i);
        }
    }
}
