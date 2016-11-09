package Ex15;

/**
 * Created by belows on 2016/11/8.
 */
public class Pug extends Dog {
    public Pug(String name) { super(name); }
    public Pug() { super(); }

    public static Factory<Pug> factory = new Factory<Pug>() {
        @Override
        public Pug create() {
            return new Pug();
        }
    };
}
