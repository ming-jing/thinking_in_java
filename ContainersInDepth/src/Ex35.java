import test.*;
import test.Test;
import test.TestParam;

import java.util.*;

/**
 * Created by belows on 2016/12/15.
 */
//TreeMap,HashMap,LinkedHashMap,WeakMap,IdentityMap,HashTable
public class Ex35 {
    public static void main(String[] args) {
        List<test.Test<Map<Integer,Integer>>> tests = new ArrayList<>();
        tests.add(new Test<Map<Integer, Integer>>("put") {
            @Override
            public int run(Map<Integer, Integer> container, TestParam param) {
                for (int i = 0; i < param.loops; ++i) {
                    container.clear();
                    for (int j = 0; j < param.size; ++j) {
                        container.put(j, j);
                    }
                }
                return param.loops * param.size;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("get") {
            @Override
            public int run(Map<Integer, Integer> container, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    for (int j=0; j<param.size; ++j) {
                        container.get(j);
                    }
                }
                return param.loops * param.size;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("iterate") {
            @Override
            public int run(Map<Integer, Integer> container, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    Iterator<Map.Entry<Integer,Integer>> it = container.entrySet().iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                return param.loops * container.size();
            }
        });

        new Tester(TreeMap.class,tests).run();

        new Tester(HashMap.class,tests).run();

        new Tester(LinkedHashMap.class,tests).run();

        new Tester(WeakHashMap.class,tests).run();

        new Tester(IdentityHashMap.class,tests).run();

        new Tester(Hashtable.class,tests).run();

        new Tester(SlowMap.class,tests).run();
    }
}
