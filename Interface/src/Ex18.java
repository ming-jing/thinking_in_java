/**
 * Created by belows on 2016/10/19.
 */

interface Cycle {
    void ride();
}

class Unicycle implements Cycle {
    @Override
    public void ride() {
        System.out.println("Unicycle ride");
    }
}

class Bicycle implements Cycle {
    @Override
    public void ride() {
        System.out.println("Bicycle ride");
    }
}

class Tricycle implements Cycle {
    @Override
    public void ride() {
        System.out.println("Tricycle ride");
    }
}

interface CycleFactory {
    Cycle create();
}

class UnicycleFactory implements CycleFactory {
    @Override
    public Cycle create() {
        return new Unicycle();
    }
}

class BicycleFactory implements CycleFactory {
    @Override
    public Cycle create() {
        return new Bicycle();
    }
}

class TricycleFactory implements CycleFactory {
    @Override
    public Cycle create() {
        return new Tricycle();
    }
}


//Unicycle, Bicycle and Tricycle
public class Ex18 {

    static void test(CycleFactory factory) {
        factory.create().ride();
    }
    public static void main(String[] args) {
        test(new UnicycleFactory());
        test(new BicycleFactory());
        test(new TricycleFactory());
    }
}
