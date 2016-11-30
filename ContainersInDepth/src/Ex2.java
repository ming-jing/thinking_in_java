import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by belows on 2016/11/28.
 */
public class Ex2 {
    public static void main(String[] args) {
        Map<String,String> cm = new HashMap<>();
        for (int i=0,size=Contries.contries.length;i<size; ++i) {
            if (Contries.contries[i][0].startsWith("A")) {
                cm.put(Contries.contries[i][0],Contries.contries[i][1]);
            }
        }
        System.out.println(cm);

        Set<String> cs = new HashSet<>();
        cs.addAll(cm.keySet());
        System.out.println(cs);
    }
}
