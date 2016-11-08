/**
 * Created by belows on 2016/11/7.
 */

interface HasBatteries {}
interface Waterproof {}
interface Shoots {}
interface InterfaceTest {}

class Toy implements InterfaceTest {
    // Comment out the following default constructor
    // to see NoSuchMethodError from (*1*)
//    Toy() {}
    Toy(int i) {}
}
class FancyToy extends Toy
        implements HasBatteries, Waterproof, Shoots,InterfaceTest {
    FancyToy() { super(1); }
}

 class ToyTest {
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() +
                " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("FancyToy");
        } catch(ClassNotFoundException e) {
            System.out.println("Can’t find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for(Class face : c.getInterfaces())
            printInfo(face);
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // Requires default constructor:
            obj = up.newInstance();
        } catch(InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch(IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}

public class Ex1 {
    
    
    public static void main(String[] args) {
        ToyTest.main(args);
    }
}
