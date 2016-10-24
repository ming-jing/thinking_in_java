/**
 * Created by belows on 2016/10/19.
 */

class Outer5 {
    class Inner {

    }
}
public class Ex5 {
    public static void main(String[] args) {
        Outer5.Inner inner = new Outer5().new Inner();
    }
}
