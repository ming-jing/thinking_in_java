package Ex13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Created by belows on 2016/11/8.
 */

class Part {
    public String toString() {
        return getClass().getSimpleName();
    }
    static List<Factory<? extends Part>> partFactories =
            new ArrayList<>();
    static List<Class<? extends Part>> classes = new ArrayList<>();

    static {
        // Collections.addAll() gives an "unchecked generic
        // array creation ... for varargs parameter" warning.
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }
    static {
        classes.add(FuelFilter.class);
        classes.add(AirFilter.class);
        classes.add(CabinAirFilter.class);
        classes.add(OilFilter.class);
        classes.add(FanBelt.class);
        classes.add(PowerSteeringBelt.class);
        classes.add(GeneratorBelt.class);
    }

    private static Random rand = new Random(47);
    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }

    public static Part createFromClass() throws IllegalAccessException,InstantiationException {
        int n = rand.nextInt(classes.size());
        return classes.get(n).newInstance();
    }

}
class Filter extends Part {}
class FuelFilter extends Filter {
    
    // Create a Class Factory for each specific type:
    public static class Factory
            implements Ex13.Factory<FuelFilter> {
        public FuelFilter create() { return new FuelFilter(); }
    }
}
class AirFilter extends Filter {
    public static class Factory
            implements Ex13.Factory<AirFilter> {
        public AirFilter create() { return new AirFilter(); }
    }
}
class CabinAirFilter extends Filter {
    public static class Factory
            implements Ex13.Factory<CabinAirFilter> {
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}
class OilFilter extends Filter {
    public static class Factory
            implements Ex13.Factory<OilFilter> {
        public OilFilter create() { return new OilFilter(); }
    }
}
class Belt extends Part {}
class FanBelt extends Belt {
    public static class Factory
            implements Ex13.Factory<FanBelt> {
        public FanBelt create() { return new FanBelt(); }
    }
}
class GeneratorBelt extends Belt {
    public static class Factory
            implements Ex13.Factory<GeneratorBelt> {
        public GeneratorBelt create() {
            return new GeneratorBelt();
        } }
}
class PowerSteeringBelt extends Belt {
    public static class Factory
            implements Ex13.Factory<PowerSteeringBelt> {
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    } }

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
    public static void main(String[] args) throws Exception {
        TypeCounter counter = new TypeCounter(Part.class);
        for(int i = 0; i < 10; i++) {
            Part part = Part.createRandom();
            System.out.println(part);
            counter.count(part.getClass());
        }
        System.out.println(counter);
        counter.clear();
        for(int i = 0; i < 10; i++) {
            Part part = Part.createFromClass();
            System.out.println(part);
            counter.count(part.getClass());
        }
        System.out.println(counter);
    }
}
