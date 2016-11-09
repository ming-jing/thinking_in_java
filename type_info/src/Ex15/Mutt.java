package Ex15;

/**
 * Created by belows on 2016/11/8.
 */
public class Mutt extends Dog {
    public Mutt(String name) { super(name); }
    public Mutt() { super(); }

    public static Factory<Mutt> factory = new Factory<Mutt>() {
        @Override
        public Mutt create() {
            return new Mutt();
        }
    };
}
