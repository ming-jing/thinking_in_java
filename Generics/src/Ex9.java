import java.util.Date;

/**
 * Created by belows on 2016/11/10.
 */
public class Ex9 {
    static class GenericMethods {
        <T1,T2,T3> void f(T1 t1, T2 t2, T3 t3) {
            System.out.println("T1:" + t1.getClass().getName() + ",T2:" + t2.getClass().getName() + ",T3:"+t3.getClass().getName());
        }
    }

    public static void main(String[] args) {
        GenericMethods genericMethods = new GenericMethods();
        genericMethods.f(1,3,5.0);
        genericMethods.<Float,Double,Double>f(3.4f,3.0,3.0);
    }
}
