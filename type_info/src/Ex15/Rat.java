package Ex15;

/**
 * Created by belows on 2016/11/8.
 */
public class Rat extends Rodent {
    public Rat(String name) { super(name); }
    public Rat() { super(); }

    public static Factory<Rat> factory = new Factory<Rat>() {
        @Override
        public Rat create() {
            return new Rat();
        }
    };
}
