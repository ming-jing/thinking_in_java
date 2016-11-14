import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Time;
import java.util.Timer;

/**
 * Created by belows on 2016/11/11.
 */
public class Ex22 {

    static class Factory {
        public<T> T create(Class<T> cls, Object... args) throws Exception {
            T t = null;
            Constructor<T> con = null;
            if (args != null) {
                Class<?>[] argsTypes = new Class[args.length];
                for (int i=0; i<args.length; ++i) {
                    argsTypes[i] = args[i].getClass();
                }
                con = cls.getDeclaredConstructor(argsTypes);
            } else {
                con = cls.getConstructor();
            }
            t = con.newInstance(args);
            return t;
        }
    }

    public static void main(String[] args) throws Exception{
        Factory factory = new Factory();
        String s = factory.create(String.class,String.valueOf(3));
        System.out.println(s);

        Timer timer = factory.create(Timer.class,"3333");
        System.out.println(timer);
    }
}
