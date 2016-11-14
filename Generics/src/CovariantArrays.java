import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by belows on 2016/11/11.
 */
class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}
public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];
        fruit[0] = new Apple(); // OK
        fruit[1] = new Jonathan(); // OK
        // Runtime type is Apple[], not Fruit[] or Orange[]:
        try {
            // Compiler allows you to add Fruit:
            fruit[0] = new Fruit(); // ArrayStoreException
        } catch(Exception e) { System.out.println(e); }
        try {
            // Compiler allows you to add Oranges:
            fruit[0] = new Orange(); // ArrayStoreException
        } catch(Exception e) { System.out.println(e); }

        System.out.println(Fruit[].class.isAssignableFrom(Apple[].class));
        System.out.println(Apple[].class.isAssignableFrom(Fruit[].class));
        System.out.println(new ArrayList<Fruit>().getClass().isAssignableFrom(new ArrayList<Apple>().getClass()));
        System.out.println(new ArrayList<Apple>().getClass().isAssignableFrom(new ArrayList<Fruit>().getClass()));

        Collection<Fruit> fruits = new ArrayList<>();
    }
}
