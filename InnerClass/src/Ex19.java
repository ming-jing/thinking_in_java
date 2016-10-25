/**
 * Created by belows on 2016/10/24.
 */

class Outer19 {

    class Inner {
        class InnerInner {

        }
    }

    static class StaticInner {
        static class StaticInnerInner {

        }
    }
}
public class Ex19 {
    public static void main(String[] args) {
        new Outer19().new Inner().new InnerInner();
        new Outer19.StaticInner.StaticInnerInner();
        new Outer19.StaticInner();
    }
}
