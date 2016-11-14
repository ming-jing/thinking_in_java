import java.util.HashMap;
import java.util.Map;

/**
 * Created by belows on 2016/11/11.
 */
public class Ex24 {
    interface IFactory<T> {
        T create(Object... args);
    }

    static class IntegerFactory implements IFactory<Integer> {
        @Override
        public Integer create(Object... args) {
            return Integer.valueOf(args[0].toString());
        }
    }

    static class StringFactory implements IFactory<String> {
        @Override
        public String create(Object... args) {
            return new String(args[0].toString());
        }
    }

    static class ClassTypeCapture {
        Map<String,IFactory<?>> factories = new HashMap<>();

        public void addType(String name,Class<? extends IFactory> factory) {
            try {
                factories.put(name, factory.newInstance());
            } catch (Exception e) {}
        }

        public Object createNew(String name, Object... args) {
            return factories.get(name).create(args);
        }
    }

    public static void main(String[] args) {
        ClassTypeCapture capture = new ClassTypeCapture();
        capture.addType("String",StringFactory.class);
        capture.addType("Integer",IntegerFactory.class);

        Object strObj = capture.createNew("String","32");
        Object intObj =capture.createNew("Integer","32");

        System.out.println(strObj);
        System.out.println(intObj);
    }
}
