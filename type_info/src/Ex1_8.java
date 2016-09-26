import java.lang.reflect.Field;

/**
 * Created by beta on 16-8-31.
 */
class Base {
    public int i;
}

class T1 extends Base {
    private int j;
}

public class Ex1_8 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        Class c = t1.getClass();
        while (c != null) {
            System.out.println(c.getName());
            for (Field field : c.getFields()) {
                System.out.print(field.getName() + " ");
            }
            System.out.println();
            c = c.getSuperclass();
        }
    }
}
