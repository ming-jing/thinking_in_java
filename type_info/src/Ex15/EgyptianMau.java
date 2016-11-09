package Ex15;

/**
 * Created by belows on 2016/11/8.
 */
public class EgyptianMau extends Cat {
    public EgyptianMau(String name) { super(name); }
    public EgyptianMau() { super(); }

    public static Factory<EgyptianMau> factory = new Factory<EgyptianMau>() {
        @Override
        public EgyptianMau create() {
            return new EgyptianMau();
        }
    };
}
