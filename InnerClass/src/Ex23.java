/**
 * Created by belows on 2016/10/24.
 */

interface U {
    void uF1();
    void uF2();
    void uF3();
}

class A {
    public U getU() {
        return new U() {
            @Override
            public void uF1() {
                System.out.println("A.f1");
            }

            @Override
            public void uF2() {
                System.out.println("A.f2");
            }

            @Override
            public void uF3() {
                System.out.println("A.f3");
            }
        };
    }
}

class B {
    private U[] us = null;
    private int index = 0;
    public B(int size) {
        us = new U[size];
    }

    public void add(U u) throws IllegalStateException {
        if (index >= us.length) {
            throw new IllegalStateException("index >= us.length");
        } else {
            us[index++] = u;
        }
    }

    public void setNull(int index) throws IllegalStateException {
        if (index<0 || index>=us.length) {
            throw new IllegalStateException("index: " + index + ",length:"+us.length);
        } else {
            us[index] = null;
        }
    }

    public void callAllMethods() {
        for (U u : us) {
            u.uF1();
            u.uF2();
            u.uF3();
        }
    }

    public void move(int index) throws IllegalStateException {
        if (index<0 || index>=us.length) {
            throw new IllegalStateException("index: " + index + ",length:"+us.length);
        } else {
            U u = us[index];
            if (u != null) {
                u.uF1();
                u.uF2();
                u.uF3();
            } else {

            }
            us[index] = null;
        }
    }
}
public class Ex23 {
    public static void main(String[]args) {
        A[] as = new A[3];
        for (int i=0; i<as.length; ++i) {
            as[i] = new A();
        }

        B b = new B(as.length);
        for (int i=0; i<as.length; ++i) {
            b.add(as[i].getU());
        }

        b.callAllMethods();

        b.move(1);
    }
}
