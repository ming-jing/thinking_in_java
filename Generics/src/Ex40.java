import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by belows on 2016/11/16.
 */
public class Ex40 {

    static class Pet {


        void speak() {
            System.out.println(getClass().getSimpleName() + " speak ");
        }

        void speak(String s) {
            System.out.println(getClass().getSimpleName() + " speak " + s);
        }
    }

    static class Dog extends Pet {

    }

    static class Cat extends Pet {}

    static class Apply {
        void apply(Pet pet) {
            pet.speak();
        }

        void apply(Object object, Method f, Object... args) {
            try {
                f.invoke(object,args);
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        List<Pet> pets = new ArrayList<>();
        for (int i=0; i<10; ++i) {
            if (i%2==0) {
                pets.add(new Dog());
            } else {
                pets.add(new Cat());
            }
        }

        System.out.println(Pet.class.getMethods());
        Apply apply = new Apply();

        for (Pet pet : pets) {
            apply.apply(pet,Pet.class.getDeclaredMethod("speak",String.class),"test");
        }
    }
}
