/**
 * Created by belows on 16/10/16.
 */

class Rodent {
    Member m = new Member("Rodent");
    Member m2 = null;

    public void setMember(Member m) {
        m2 = m;
        m2.addRef();
    }

    public void eat() {
        System.out.println("Rodent.eat()");
    }

    public Rodent() {
        System.out.println("Rodent constructor");
    }

    public void dispose() {
        System.out.println("Rodent dispose");
        m2.dispose();
        m.dispose();
    }
}

class  Mouse extends Rodent {

    Member m = new Member("Mouse");
    @Override
    public void eat() {
        System.out.println("Mouse.eat()");
    }

    Mouse() {
        System.out.println("Mouse constructor");
    }

    public void dispose() {
        System.out.println("Mouse dispose");
        m.dispose();
        super.dispose();
    }
}

class Gerbil extends Rodent {

    Member m = new Member("Gerbil");
    @Override
    public void eat() {
        System.out.println("Gerbil.eat()");
    }

    Gerbil() {
        System.out.println("Gerbil constructor");
    }

    public void dispose() {
        System.out.println("Gerbil dispose");
        m.dispose();
        super.dispose();
    }
}

class Hamste extends Rodent {

    Member m = new Member("Hamste");

    @Override
    public void eat() {
        System.out.println("Hamste.eat()");
    }

    Hamste() {
        System.out.println("Hamste constructor");
    }

    public void dispose() {
        System.out.println("Hamste dispose");
        m.dispose();
        super.dispose();
    }
}

class Member {

    private int refCount = 0;
    private String s ;
    public void addRef() {
        ++refCount;
    }

    Member(String s) {
        ++refCount;
         this.s = s;
        System.out.println(s + " member");
    }

    public void dispose() {
        if (--refCount == 0) {
            System.out.println(s + " Member dispose");
        }
    }
}

public class Ex12 {
    public static void main(String[] args) {
        Member m = new Member("Sharing");
        Rodent r1 = new Mouse();
        Rodent r2 = new Gerbil();
        Rodent r3 = new Hamste();
        r1.setMember(m);
        r2.setMember(m);
        r3.setMember(m);
        r3.dispose();
        r2.dispose();
        r1.dispose();
        m.dispose();
    }
}
