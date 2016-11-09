package Ex12.coffee;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by belows on 2016/11/8.
 */
public class Ex12 {
    private static class TypeCounter extends HashMap<Class,Integer> {
        Class baseType;

        TypeCounter(Class baseType) {
            this.baseType = baseType;
        }

        public void count(Class cls) {
            while (true) {
                if (cls!=null && baseType.isAssignableFrom(cls)) {
                    Integer value = get(cls);
                    if (value == null) {
                        put(cls,1);
                    } else {
                        put(cls,value+1);
                    }
                    cls = cls.getSuperclass();
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Coffee.class);
        CoffeeGenerator generator = new CoffeeGenerator(20);
        Iterator<Coffee> it = generator.iterator();
        while (it.hasNext()) {
            Coffee coffee = it.next();
            counter.count(coffee.getClass());
        }
        System.out.println(counter);
    }
}
