package Ex15;

/**
 * Created by belows on 2016/11/8.
 */
public class Cat extends Pet {
    public Cat(String name) { super(name); }
    public Cat() { super(); }

    public static Factory<Cat> factory = new Factory<Cat>() {
        @Override
        public Cat create() {
            return new Cat();
        }
    };
}
