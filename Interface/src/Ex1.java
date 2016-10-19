/**
 * Created by belows on 16/10/16.
 */

 interface Rodent {
     void eat();
}

class  Mouse implements Rodent {
    @Override
    public void eat() {
        System.out.println("Mouse.eat()");
    }
}

class Gerbil implements Rodent {
    @Override
    public void eat() {
        System.out.println("Gerbil.eat()");
    }
}

class Hamste implements Rodent {
    @Override
    public void eat() {
        System.out.println("Hamste.eat()");
    }
}

public class Ex1 {

    public static void main(String[] args) {
        new Mouse().eat();
        new Gerbil().eat();
        new Hamste().eat();
    }
}
