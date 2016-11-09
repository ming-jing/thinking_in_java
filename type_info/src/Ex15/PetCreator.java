package Ex15;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by belows on 2016/11/8.
 */
public abstract class PetCreator {

    private Random random = new Random(47);
    public abstract List<Class<? extends Pet>> types();

    public Pet randPet() throws IllegalAccessException, InstantiationException {
        List<Class<? extends Pet>> types = types();
        int index = random.nextInt(types.size());
        Class<? extends Pet> petType = types.get(index);
        return petType.newInstance();
    }

    public List<Pet> listPets(int size) {
        List<Pet> pets = new ArrayList<>(size);
        for (int i=0;i<size; ++i) {
            try {
                pets.add(randPet());
            } catch (IllegalAccessException e) {}
            catch (InstantiationException e) {}
        }
        return pets;
    }

    public Pet[] arrayPets(int size) {
        Pet[] pets = new Pet[size];
        for (int i=0; i<size; ++i) {
            try {
                pets[i] = randPet();
            }catch (IllegalAccessException e) {}
            catch (InstantiationException e) {}
        }
        return pets;
    }
}
