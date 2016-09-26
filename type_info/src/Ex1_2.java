package Ex1_2;

/**
 * Created by beta on 16-8-31.
 */
interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

interface NewInterface {
}

class Toy {
    //    Toy() {}
    Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots, NewInterface {
    FancyToy(int i) {
        super(i);
    }
}

public class Ex1_2 {
    static void print(Class c) {
        System.out.println("Class Name:" + c.getName() + ",is interface?[" + c.isInterface() + "]");
        System.out.println("Simple Name:" + c.getSimpleName());
        System.out.println("Canonical Name:" + c.getCanonicalName());
    }

    public static void main(String[] args) {
        Class ct = null;
        try {
            ct = Class.forName("Ex1_2.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        }
        print(ct);
        for (Class i : ct.getInterfaces()) {
            print(i);
        }
        Class up = ct.getSuperclass();
        try {
            up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("cannot init");
        } catch (IllegalAccessException e) {
            System.out.println("cannot access");
        }
        print(up);
    }
}
