import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by beta on 16-8-31.
 */
class Pet {
}

class Dog extends Pet {
}

class Mutt extends Dog {
}

class Pug extends Dog {
}

class Cat extends Pet {
}

class EgyptianMau extends Cat {
}

class Manx extends Cat {
}

class Cymic extends Manx {
}

class Rodent extends Pet {
}

class Rat extends Rodent {
}

class Mouse extends Rodent {
}

class Hamster extends Rodent {
}

public abstract class PetCreator {
    private Random random = new Random(47);

    abstract List<Class<? extends Pet>> types();

    public Pet randomPet() {
        int index = random.nextInt(types().size());
        try {
            Pet p = types().get(index).newInstance();
            return p;
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        }
        return null;
    }

    public Pet[] createArray(int size) {
        Pet[] pets = new Pet[size];
        for (int i = 0; i < size; ++i) {
            pets[i] = randomPet();
        }
        return pets;
    }

    public List<Pet> list(int size) {
        List<Pet> list = new ArrayList<>();
        Collections.addAll(list, createArray(size));
        return list;
    }
}