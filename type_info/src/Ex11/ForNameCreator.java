package Ex11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by belows on 2016/11/8.
 */
public class ForNameCreator extends PetCreator {

    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static String[] typeNames = {
            "Ex11.Mutt",
            "Ex11.Pug",
            "Ex11.EgyptianMau",
            "Ex11.Manx",
            "Ex11.Cymric",
            "Ex11.Rat",
            "Ex11.Mouse",
            "Ex11.Hamster"
    };
    
    public static void main(String[] args) {
        System.out.println(new ForNameCreator().listPets(20));
    }

    static {
        for (String name : typeNames) {
            try {
                Class<? extends Pet> type = (Class<? extends Pet>) Class.forName(name);
                types.add(type);
            } catch (ClassNotFoundException e) {}
        }
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
