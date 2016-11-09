package Ex15;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by belows on 2016/11/9.
 */
public class Pets {
    static PetCreator creator = new PetCreator() {

        List<Factory<? extends Pet>> factories = new ArrayList<>();
        Random rand = new Random(47);
        {
            factories.add(Cat.factory);
            factories.add(Cymric.factory);
            factories.add(Dog.factory);
            factories.add(EgyptianMau.factory);
            factories.add(Gerbil.factory);
        }

        @Override
        public List<Class<? extends Pet>> types() {
            return null;
        }

        @Override
        public Pet randPet() throws IllegalAccessException, InstantiationException {
            return factories.get(rand.nextInt(factories.size())).create();
        }

        @Override
        public List<Pet> listPets(int size) {
            List<Pet> pets = new ArrayList<>();
            for (int i=0; i<size; ++i) {
                try {
                    Pet pet = randPet();
                    pets.add(pet);
                } catch (IllegalAccessException e) {}
                catch (InstantiationException e) {}
            }
            return pets;
        }

        @Override
        public Pet[] arrayPets(int size) {
            Pet[] pets = new Pet[size];
            for (int i=0; i<size; ++i) {
                try {
                    Pet pet = randPet();
                    pets[i] = pet;
                } catch (IllegalAccessException e) {}
                catch (InstantiationException e) {}
            }
            return pets;
        }
    };

    static Pet randomPet() throws IllegalAccessException, InstantiationException {
        return creator.randPet();
    }

    static List<Pet> listPets(int size) {
        return creator.listPets(size);
    }

    public static void main(String[] args) {
        System.out.println(listPets(20));
    }
}
