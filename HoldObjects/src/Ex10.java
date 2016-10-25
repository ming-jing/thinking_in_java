import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by belows on 16/10/16.
 */

//Rodent: Mouse, Gerbil, Hamste

class Rodent {
    public void eat() {
        System.out.println("Rodent.eat()");
    }
}

class  Mouse extends Rodent {
    @Override
    public void eat() {
        System.out.println("Mouse.eat()");
    }
}

class Gerbil10 extends Rodent {
    @Override
    public void eat() {
        System.out.println("Gerbil.eat()");
    }
}

class Hamste extends Rodent {
    @Override
    public void eat() {
        System.out.println("Hamste.eat()");
    }
}

class Member {
    Member(String s) {
        System.out.println(s + " member");
    }
}

public class Ex10 {

    static Random random = new Random(47);
    static Rodent next() {
        switch (random.nextInt(3)) {
            default:
            case 0:
                return new Mouse();
            case 1:
                return new Gerbil10();
            case 2:
                return new Hamste();
        }
    }

    public static void main(String[] args) {

//        Rodent[] rodents = new Rodent[10];
//        for (int i=0; i<rodents.length; ++i) {
//            rodents[i] = next();
//        }
//        for (Rodent rodent : rodents) {
//            rodent.eat();
//        }
        List<Rodent> rodents = new ArrayList<>();
        for (int i=0; i<10; ++i) {
            rodents.add(next());
        }
//        for (Rodent r : rodents) {
//            r.eat();
//        }
        Iterator<Rodent> it = rodents.iterator();
        while (it.hasNext()) {
            ((Rodent)it.next()).eat();
        }
    }
}
