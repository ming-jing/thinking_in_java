package Ex15;

/**
 * Created by belows on 2016/11/8.
 */
public class Hamster extends Rodent {
    public Hamster(String name) { super(name); }
    public Hamster() { super(); }

    public static Factory<Hamster> factory = new Factory<Hamster>() {
        @Override
        public Hamster create() {
            return new Hamster();
        }
    };
}
