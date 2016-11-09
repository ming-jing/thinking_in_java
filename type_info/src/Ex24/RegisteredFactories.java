package Ex24;

/**
 * Created by belows on 2016/11/9.
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by belows on 2016/11/8.
 */

interface Part {

    public default void test() {
        System.out.println(getClass().getSimpleName() + " test() ");
    }

}
class Filter implements Ex24.Part {}
class FuelFilter extends Ex24.Filter {

    // Create a Class Factory for each specific type:
    public static class Factory
            implements Ex24.Factory<Ex24.FuelFilter> {
        public Ex24.FuelFilter create() { return new Ex24.FuelFilter(); }
    }
}
class AirFilter extends Ex24.Filter {
    public static class Factory
            implements Ex24.Factory<Ex24.AirFilter> {
        public Ex24.AirFilter create() { return new Ex24.AirFilter(); }
    }
}
class CabinAirFilter extends Ex24.Filter {
    public static class Factory
            implements Ex24.Factory<Ex24.CabinAirFilter> {
        public Ex24.CabinAirFilter create() {
            return new Ex24.CabinAirFilter();
        }
    }
}
class OilFilter extends Ex24.Filter {
    public static class Factory
            implements Ex24.Factory<Ex24.OilFilter> {
        public Ex24.OilFilter create() { return new Ex24.OilFilter(); }
    }
}
class Belt implements Ex24.Part {}
class FanBelt extends Ex24.Belt {
    public static class Factory
            implements Ex24.Factory<Ex24.FanBelt> {
        public Ex24.FanBelt create() { return new Ex24.FanBelt(); }
    }
}
class GeneratorBelt extends Ex24.Belt {
    public static class Factory
            implements Ex24.Factory<Ex24.GeneratorBelt> {
        public Ex24.GeneratorBelt create() {
            return new Ex24.GeneratorBelt();
        } }
}
class PowerSteeringBelt extends Ex24.Belt {
    public static class Factory
            implements Ex24.Factory<Ex24.PowerSteeringBelt> {
        public Ex24.PowerSteeringBelt create() {
            return new Ex24.PowerSteeringBelt();
        }
    } }

class NullProxyHandler implements InvocationHandler {

    Class<? extends Part> cls;

    NullProxyHandler(Class<? extends Part> cls) {
        this.cls = cls;
    }

    Part proxied = new Part() {
        @Override
        public void test() {
            System.out.println(cls.getSimpleName() + " null test()");
        }
    };

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(proxied,args);
    }
}

class TypeCounter extends HashMap<Class,Integer> {
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
public class RegisteredFactories {

    public static Part nullPartInstance(Class<? extends Part> cls) {
        Part nullPart = (Part) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Part.class},new NullProxyHandler(cls));
        return nullPart;
    }

    public static void main(String[] args) throws Exception {
        List<Part> parts = new ArrayList<>();
        List<Class<? extends Factory<? extends Part>>> factories = new ArrayList<>();
        factories.add(AirFilter.Factory.class);
        factories.add(CabinAirFilter.Factory.class);
        factories.add(FanBelt.Factory.class);
        factories.add(FuelFilter.Factory.class);
        factories.add(GeneratorBelt.Factory.class);
        factories.add(OilFilter.Factory.class);
        factories.add(PowerSteeringBelt.Factory.class);
        Random ran = new Random(47);
        for (int i=0; i<20; ++i) {
            int index = ran.nextInt(factories.size());
            if (index %5 == 0) {
                nullPartInstance(factories.get(index).newInstance().create().getClass()).test();
            } else {
                Factory<? extends Part> factory = factories.get(index).newInstance();
                factory.create().test();
            }
        }
    }
}

