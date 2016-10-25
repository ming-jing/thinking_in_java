import java.util.*;

/**
 * Created by belows on 2016/10/25.
 */



public class Ex17 {
    static class Gerbil {
        int gerbilNumber;
        Gerbil(int number) {
            gerbilNumber = number;
        }

        public void hop() {
            System.out.println("Gerbil " + gerbilNumber + " is hopping");
        }
    }

    public static void main(String[] args) {
        Map<String, Gerbil> hashMap = new HashMap<>();
        for (int i=0; i<10; ++i) {
            hashMap.put("Test"+i,new Gerbil(i));
        }
        Iterator<String> it = hashMap.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            Gerbil g = hashMap.get(key);
            g.hop();
        }
    }
}
