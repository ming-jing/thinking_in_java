import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by belows on 2016/10/25.
 */
public class Ex8 {

    /**
     * Created by belows on 2016/10/25.
     */

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
            List<Gerbil> gerbils = new ArrayList<>();
            for (int i=0; i<10; ++i) {
                gerbils.add(new Gerbil(i+1));
            }
//            for (Gerbil g : gerbils) {
//                g.hop();
//            }
            Iterator<Gerbil> gi = gerbils.iterator();
            while (gi.hasNext()) {
                (gi.next()).hop();
            }
    }

}
