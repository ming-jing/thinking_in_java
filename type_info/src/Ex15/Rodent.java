package Ex15;

/**
 * Created by belows on 2016/11/8.
 */
public class Rodent extends Pet {
    public Rodent(String name) { super(name); }
    public Rodent() { super(); }

    public static Factory<Rodent> factory = new Factory<Rodent>() {
        @Override
        public Rodent create() {
            return new Rodent();
        }
    };
}
