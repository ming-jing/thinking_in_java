package Ex11;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by belows on 2016/11/8.
 */
public class LiteralPetCreator extends PetCreator {

    public static List<Class<? extends Pet>> types = new ArrayList<>();

    static {
        types.add(Mutt.class);
        types.add(Pug.class);
        types.add(EgyptianMau.class);
        types.add(Manx.class);
        types.add(Cymric.class);
        types.add(Rat.class);
        types.add(Mouse.class);
        types.add(Hamster.class);
        types.add(Gerbil.class);
    }
    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
