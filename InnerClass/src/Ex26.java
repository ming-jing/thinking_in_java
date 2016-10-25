/**
 * Created by belows on 2016/10/24.
 */
class Outer26 {
    private static int i = 3;
    protected int k = 3;
    Innner innner = new Innner();
    {
        innner = new Innner();
    }

    Outer26() {
        innner = new Innner();
    }

    //static  Innner sInner = new Innner();//Outer26.this can't be reference from a static context
    static {
        //sInner  = new Innner()//Outer26.this can't be reference from a static context
    }
    class Innner {
//        Innner(int i) {}
        void test() {
            ++i;
        }
    }

    static class TT {
        void test() {
            new Outer26().k ++;
           ++Outer26.i;
        }
    }
}

public class Ex26 {
    public static void main(String[]args) {
        Outer26.Innner in = new Outer26().new Innner();
    }
}
