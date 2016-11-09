package Ex15;

/**
 * Created by belows on 2016/11/8.
 */
public class Mouse extends Rodent {
    public Mouse(String name) { super(name); }
    public Mouse() { super(); }

    public static Factory<Mouse> factory = new Factory<Mouse>() {
        @Override
        public Mouse create() {
            return new Mouse();
        }
    };
}
