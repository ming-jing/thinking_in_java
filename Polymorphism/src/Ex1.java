/**
 * Created by belows on 16/10/13.
 */

abstract class Cycle {
    abstract void ride();
    abstract int wheels();
}

class Unicycle extends Cycle {
    @Override
    void ride() {
        System.out.println("Unicycle ride");
    }

    @Override
    int wheels() {
        return 1;
    }

    void balance() {
        System.out.println("Unicycle balance");
    }
}

class Bicycle extends Cycle {
    @Override
    void ride() {
        System.out.println("Bicycle ride");
    }

    @Override
    int wheels() {
        return 2;
    }

    void balance() {
        System.out.println("Bicycle balance");
    }
}

class Tricycle extends Cycle {
    @Override
    void ride() {
        System.out.println("Tricycle ride");
    }

    @Override
    int wheels() {
        return 3;
    }
}

class Test1 {
    private int i;
    {
        System.out.println("before initer i = " + i);
        i = 3;
        System.out.println("after initer i = " + i);
    }

    Test1() {
        System.out.println("test1 constructor");
    }

}

class TT extends Test1 {}

public class Ex1 {

    private static void ride(Cycle cycle) {
        cycle.ride();
        System.out.println(cycle.wheels());
        ((Bicycle)cycle).balance();
    }

    public static void main(String[] args) {
//        ride(new Bicycle());
//        ride(new Unicycle());
//        ride(new Tricycle());
        new TT();
    }
}
