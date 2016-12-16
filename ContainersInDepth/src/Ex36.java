import test.*;
import test.Test;
import test.TestParam;

import java.util.*;

/**
 * Created by belows on 2016/12/15.
 */
public class Ex36 {

    private static class MapEntry<K,V> implements Map.Entry<K,V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            return this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (! (obj instanceof MapEntry)) {
                return false;
            }
            MapEntry<K,V> other = (MapEntry<K,V>) obj;
            return (other.key==null?key==null:other.key.equals(key))
                    && (other.value==null?value==null:other.value.equals(value));
        }

        @Override
        public int hashCode() {
            int result  = 17;
            result = result * 37 + key.hashCode();
            return  result;
        }
    }
    public static class SlowMap<K,V> extends AbstractMap<K,V> {

        List<MapEntry<K,V>> entryList = new ArrayList<>();


        @Override
        public Set<Entry<K, V>> entrySet() {
            return new HashSet<>(entryList);
        }

        @Override
        public V put(K key, V value) {
            for (MapEntry<K,V> item : entryList) {
                if (item.key.equals(key)) {
                    return null;
                }
            }

            MapEntry<K,V> entry = new MapEntry<K, V>(key,value);
            entryList.add(entry);
            return value;
        }

        @Override
        public V get(Object key) {
            for (MapEntry<K,V> item :entryList) {
                if (item.key.equals(key)) {
                    return item.value;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }

    public static class SortSlowMap<K extends Comparable<K>,V> extends AbstractMap<K,V> {

        List<MapEntry<K,V>> entryList = new ArrayList<>();

        @Override
        public Set<Entry<K, V>> entrySet() {
            return new HashSet<>(entryList);
        }

        @Override
        public V put(K key, V value) {
            int index = 0;
            for (int i=0,size=entryList.size(); i<size; ++i) {
                Entry<K,V> entry = entryList.get(i);
                int res = key.compareTo(entry.getKey());
                index = i;
                if (res < 0) {
                    break;
                } else if (res == 0) {
                    return null;
                }
            }
            entryList.add(index,new MapEntry<K, V>(key,value));
            return value;
        }

        @Override
        public V get(Object key) {
            if (!(key instanceof Comparable)) {
                return null;
            }
            int index = Collections.binarySearch(entryList, new MapEntry(key, null), new Comparator<MapEntry>() {
                @Override
                public int compare(MapEntry o1, MapEntry o2) {
                    return ((Comparable)o1.key).compareTo((Comparable)o2.key);
                }
            });
            if(index <0 || index >= entryList.size()) {
                return null;
            }
            return entryList.get(index).value;
        }
    }

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


        Map<Integer,Integer> map = new SlowMap<>();
        for (int i=0; i<10; ++i) {
            map.put(i,i);
        }
        for (int i=0; i<10; ++i) {
            map.put(i,i);
        }
        System.out.println(map);

        map = new SortSlowMap<>();
        for (int i=0; i<10; ++i) {
            map.put(i,i);
        }
        for (int i=0; i<10; ++i) {
            map.put(i,i);
        }
        System.out.println(map);

        new Tester(SlowMap.class,tests).run();
        new Tester(SortSlowMap.class,tests).run();
    }
}
