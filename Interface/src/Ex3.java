/**
 * Created by belows on 16/10/16.
 */

abstract class Base3 {
        abstract void print();
    Base3() {
        print();
    }
}

class Test3 extends Base3 {

    int i = 3;
    @Override
    void print() {
        System.out.println("i=" +i);
    }
}

public class Ex3 {
    public static void main(String[] args) {
        new Test3().print();
    }
}
