package ex14;

/**
 * Created by belows on 2016/10/19.
 */

interface inter1 {
    void test11();
    void test12();
}

interface inter2 {
    void test21();
    void test22();
}

interface inter3 {
    void test31();
    void test32();
}

interface inter extends inter1,inter2,inter3 {
    void test();
}

abstract class Base {
    abstract void base();
}

class T extends Base implements inter {
    @Override
    public void test11() {

    }

    @Override
    public void test12() {

    }

    @Override
    public void test21() {

    }

    @Override
    public void test22() {

    }

    @Override
    public void test31() {

    }

    @Override
    public void test32() {

    }

    @Override
    public void test() {

    }

    @Override
    void base() {

    }
}



public class Ex14 {

    static void i1(inter1 inter1) {}
    static void i2(inter2 inter2) {}
    static void i3(inter3 inter3) {}
    static void i(inter inter) {}
    static void base(Base b) {}

    public static void main(String[] args) {
        T t = new T();
        i1(t);
        i2(t);
        i3(t);
        i(t);
        base(t);
    }
}
