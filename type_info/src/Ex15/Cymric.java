package Ex15;

/**
 * Created by belows on 2016/11/8.
 */
public class Cymric extends Manx {
    public Cymric(String name) { super(name); }
    public Cymric() { super(); }

    public static Factory<Cymric> factory = new Factory<Cymric>() {
        @Override
        public Cymric create() {
            return new Cymric();
        }
    };
}