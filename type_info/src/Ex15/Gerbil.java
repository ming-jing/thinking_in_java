package Ex15;

/**
 * Created by belows on 2016/11/8.
 */
public class Gerbil extends Rodent {
    Gerbil(String name) {
        super(name);
    }

    Gerbil() {}

    public static Factory<Gerbil> factory = new Factory<Gerbil>() {
        @Override
        public Gerbil create() {
            return new Gerbil();
        }
    };
}
