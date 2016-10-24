/**
 * Created by belows on 2016/10/19.
 */

class Outer {
    String s;
    public Outer(String s) {
        this.s = s;
    }
    class Inner {
        @Override
        public String toString() {
            return s;
        }
    }

    public Inner getInner() {
        return new Inner();
    }
}
public class Ex1 {
    public static void main(String []args) {
        Outer.Inner inner = new Outer("Outer String").getInner();
        System.out.println(inner);
    }
}
