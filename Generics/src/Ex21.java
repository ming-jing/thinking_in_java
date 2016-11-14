import java.util.*;

/**
 * Created by belows on 2016/11/10.
 */
public class Ex21 {

    static class ClassTypeCapture {
        Map<String,Class<?>> types = new HashMap<>();

        void addType(String name, Class<?> cls) {
            types.put(name,cls);
        }

        Object createNew(String name) throws ClassNotFoundException,IllegalAccessException,InstantiationException{
            Class<?> cls = types.get(name);
            if (cls != null) {
                return cls.newInstance();
            } else {
                throw new ClassNotFoundException();
            }
        }
    }

    public static void main(String[] args) throws Exception {
       ClassTypeCapture classTypeCapture = new ClassTypeCapture();
        classTypeCapture.addType("String",String.class);
//        classTypeCapture.addType("Calendar", Calendar.class);
        classTypeCapture.addType("Timer", Timer.class);
        classTypeCapture.addType("Integer",Integer.class);

        classTypeCapture.createNew("String");
        classTypeCapture.createNew("Timer");
    }
}
