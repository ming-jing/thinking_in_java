package Ex15;

/**
 * Created by belows on 2016/11/8.
 */
public class Pet extends Individual {
    public Pet(String name) { super(name); }
    public Pet() { super(); }

    public static Factory<Pet> factory = new Factory<Pet>() {
        @Override
        public Pet create() {
            return new Pet();
        }
    };
}
