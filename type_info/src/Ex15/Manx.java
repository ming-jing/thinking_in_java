package Ex15;

/**
 * Created by belows on 2016/11/8.
 */
public class Manx extends Cat {
    public Manx(String name) { super(name); }
    public Manx() { super(); }

    public static Factory<Manx> factory = new Factory<Manx>() {
        @Override
        public Manx create() {
            return new Manx();
        }
    };
}
