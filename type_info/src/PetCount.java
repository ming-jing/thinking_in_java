import java.util.*;

/**
 * Created by beta on 16-8-31.
 */
public class PetCount {
    static class PetCounter extends HashMap<Class<? extends Pet>, Integer> {
        public void count(Class<? extends Pet> cj) {
            Integer c = get(cj);
            if (c == null) {
                put(cj, 1);
            } else {
                put(cj, c + 1);
            }
            Collection c1 = null;
        }
    }

    public static void main(String[] args) {
//        PetCounter counter = new PetCounter();
//        ForNameCreator creator = new ForNameCreator();
//        for (Pet pet : creator.list(20)) {
//            System.out.print(pet.getClass().getSimpleName() + " ");
//            Class c = pet.getClass();
//            while (c!=null && Pet.class.isAssignableFrom(c)) {
//                counter.count(c);
//                c= c.getSuperclass();
//            }
//        }
//        Collection c = null;
//        System.out.println();
//        System.out.println(counter);
        List<String> test = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            test.add("Test " + i);
        }
        Collections.rotate(test, 1);
        System.out.println(test);
//        for (int i=0; i<test.size();++i) {
//            test.remove(0);
//        }

    }
}
