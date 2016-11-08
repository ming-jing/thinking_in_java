import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/**
 * Created by belows on 2016/11/7.
 */
public class Ex10 {

    public static class T {
        static {
            System.out.println("T Loading");
        }
    }

    public static class Test extends T {

        static {
            System.out.println("Test Loading");
        }
    }

    public static void main(String[] args) throws Exception {
        char[] c = new char[3];
//        System.out.println(c.getClass().getName());
        System.out.println(int.class.equals(Integer.TYPE));
        Class c1 = Class.forName("Ex10$Test");
    }
}
