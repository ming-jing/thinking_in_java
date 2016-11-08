package Ex11;

import java.util.HashMap;
import java.util.List;

/**
 * Created by belows on 2016/11/8.
 */
public class TypeCount {
    private static class TypeCounter extends HashMap<Class,Integer> {
        Class baseType;

        TypeCounter(Class baseType) {
            this.baseType = baseType;
        }

        public void count(Class cls) {
            while (true) {
                if (cls!=null && baseType.isAssignableFrom(cls)) {
                    Integer value = get(cls);
                    if (value == null) {
                        put(cls,1);
                    } else {
                        put(cls,value+1);
                    }
                    cls = cls.getSuperclass();
                } else {
                    break;
                }
            }
        }
    }

    private static TypeCounter counter = new TypeCounter(Pet.class);

    public static void countPets(PetCreator creator) {
        counter.clear();
        List<Pet> pets = creator.listPets(20);
        for (Pet pet : pets) {
            System.out.print(pet.getClass().getSimpleName()+ " ");
            counter.count(pet.getClass());
        }
        System.out.println();
        System.out.println(counter);
    }
    public static void main(String[]args) {
        countPets(new LiteralPetCreator());
    }
}
