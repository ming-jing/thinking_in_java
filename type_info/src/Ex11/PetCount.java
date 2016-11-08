package Ex11;

import java.util.HashMap;
import java.util.List;

/**
 * Created by belows on 2016/11/8.
 */
public class PetCount {
    private static class PetCounter extends HashMap<Class<? extends Pet>,Integer> {
        public void count(Class<? extends Pet> cls) {
            Integer value = get(cls);
            if (value == null) {
                put(cls,1);
            } else {
                put(cls, value+1);
            }
            while (true) {
                Class superCls = cls.getSuperclass();
                if (superCls!=null && Pet.class.isAssignableFrom(superCls)) {
                    value = get(superCls);
                    if (value == null) {
                        put(superCls,1);
                    } else {
                        put(superCls,value+1);
                    }
                    cls = superCls;
                } else {
                    break;
                }
            }
        }
    }

    static PetCounter counter = new PetCounter();

    public static void countPets(PetCreator creator) {
        List<Pet> pets = creator.listPets(20);
        counter.clear();
        for (Pet pet : pets) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            counter.count(pet.getClass());
        }
        System.out.println();
        System.out.println(counter);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
        countPets(new LiteralPetCreator());
    }
}
