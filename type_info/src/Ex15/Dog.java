package Ex15;

/**
 * Created by belows on 2016/11/8.
 */
public class Dog extends Pet {
    public Dog(String name) { super(name); }
    public Dog() { super(); }

    public static Factory<Dog> factory = new Factory<Dog>() {
        @Override
        public Dog create() {
            return new Dog();
        }
    };
}
