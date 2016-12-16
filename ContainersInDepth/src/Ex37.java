import test.*;
import test.Test;
import test.TestParam;

import java.util.*;

/**
 * Created by belows on 2016/12/15.
 */
public class Ex37 {

    public static class ArraySimpleHashMap<K,V> extends AbstractMap<K,V> {

        private static final int size =1024;

        ArrayList<MapEntry<K,V>>[] map = new ArrayList[size];

        @Override
        public Set<Entry<K, V>> entrySet() {
            HashSet<Entry<K,V>> set = new HashSet<>();
            for (ArrayList<MapEntry<K,V>> item : map) {
                if (item != null) {
                    for (MapEntry<K,V> entry : item) {
                        set.add(entry);
                    }
                }
            }
            return set;
        }

        @Override
        public V put(K key, V value) {
            int index = indexOfKey(key);
            if (map[index] == null) {
                map[index] = new ArrayList<>();
            }
            ArrayList<MapEntry<K,V>> list = map[index];
            for (Entry<K,V> entry: list) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
            list.add(new MapEntry<K, V>(key,value));
            return value;
        }

        @Override
        public V get(Object key) {
            int index = indexOfKey(key);
            if (map[index] == null) {
                return null;
            }
            ArrayList<MapEntry<K,V>> list = map[index];
            for (Entry<K,V> entry :list) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
            return null;
        }

        private int indexOfKey(Object key) {
            return Math.abs(key.hashCode()) % size;
        }
    }

    static List<test.Test<Map<Integer,Integer>>> tests = new ArrayList<>();
    static {
        tests.add(new test.Test<Map<Integer, Integer>>("put") {
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
                for (int i = 0; i < param.loops; ++i) {
                    for (int j = 0; j < param.size; ++j) {
                        container.get(j);
                    }
                }
                return param.loops * param.size;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("iterate") {
            @Override
            public int run(Map<Integer, Integer> container, TestParam param) {
                for (int i = 0; i < param.loops; ++i) {
                    Iterator<Map.Entry<Integer, Integer>> it = container.entrySet().iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                return param.loops * container.size();
            }
        });
    }
    public static void main(String[] args) {


//        new Tester(Ex36.SlowMap.class,tests).run();
//        new Tester(Ex36.SortSlowMap.class,tests).run();
        new Tester(SimpleHashMap.class,tests).run();
        new Tester(ArraySimpleHashMap.class,tests).run();
    }
}
