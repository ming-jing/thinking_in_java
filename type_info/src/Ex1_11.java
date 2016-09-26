import java.util.ArrayList;
import java.util.List;

/**
 * Created by beta on 16-8-31.
 */

class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> ps = new ArrayList<>();

    static {
        try {
            ps.add((Class<? extends Pet>) Class.forName("Mutt"));
            ps.add((Class<? extends Pet>) Class.forName("Pug"));
            ps.add((Class<? extends Pet>) Class.forName("EgyptianMau"));
            ps.add((Class<? extends Pet>) Class.forName("Manx"));
            ps.add((Class<? extends Pet>) Class.forName("Cymric"));
            ps.add((Class<? extends Pet>) Class.forName("Rat"));
            ps.add((Class<? extends Pet>) Class.forName("Mouse"));
            ps.add((Class<? extends Pet>) Class.forName("Hamster"));
        } catch (ClassNotFoundException e) {
        }
    }

    @Override
    List<Class<? extends Pet>> types() {
        return ps;
    }
}

public class Ex1_11 {

    public static void main(String[] args) {

    }
}
