/**
 * Created by belows on 2016/10/24.
 */

interface Cycle {
    void ride();
}

interface CycleFactory {
    Cycle create();
}

class Unicycle implements Cycle {
    @Override
    public void ride() {
        System.out.println("Unicycle ride");
    }

    public static CycleFactory factory  = new CycleFactory() {
        @Override
        public Cycle create() {
            return new Unicycle();
        }
    };

}

class Bicycle implements Cycle {
    @Override
    public void ride() {
        System.out.println("Bicycle ride");
    }

    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle create() {
            return new Bicycle();
        }
    };
}

class Tricycle implements Cycle {
    @Override
    public void ride() {
        System.out.println("Tricycle ride");
    }

    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle create() {
            return new Tricycle();
        }
    };
}



public class Ex16 {

    public static void ride(CycleFactory factory) {
        factory.create().ride();
    }

    public static void main(String[] args) {
        ride(Unicycle.factory);
        ride(Bicycle.factory);
        ride(Tricycle.factory);
    }
}
