import test.Tester;

import java.util.*;

/**
 * Created by belows on 2016/12/15.
 */
public class Ex39 {
    public static class SimpleMap<K,V> extends AbstractMap<K,V> {

        private int capacity = 1024;
        private int size = 0;
        private float loadFactor = 0.75f;

        LinkedList<MapEntry<K,V>>[] map = new LinkedList[capacity];

        @Override
        public Set<Entry<K, V>> entrySet() {
            HashSet<Entry<K,V>> set = new HashSet<>();
            for (LinkedList<MapEntry<K,V>> entries : map) {
                if (entries == null) {
                    continue;
                }
                for (MapEntry<K,V> entry : entries) {
                    set.add(entry);
                }
            }
            return set;
        }

        private void reHash() {
            System.out.println("rehash,size:"+size+",capacity:" + capacity);
            capacity = capacity << 1;
            LinkedList<MapEntry<K,V>>[] newMap = new LinkedList[capacity];
            for (LinkedList<MapEntry<K,V>> entries : map) {
                if (entries != null) {
                    for (MapEntry<K,V> entry : entries) {
                        int index = indexOfKey(entry.getKey());
                        if (newMap[index] == null) {
                            newMap[index] = new LinkedList<>();
                        }
                        LinkedList<MapEntry<K,V>> list = newMap[index];
                        list.add(entry);
                    }
                }
            }
            map = newMap;
        }

        @Override
        public V put(K key, V value) {
            if (size/(float)capacity >= loadFactor) {
                reHash();
            }
            int index = indexOfKey(key);
            if (map[index] == null) {
                map[index] = new LinkedList<>();
            }
            LinkedList<MapEntry<K,V>> list = map[index];
            for (Entry<K,V> entry : list) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
            list.add(new MapEntry<K, V>(key,value));
            ++size;
            return value;
        }

        @Override
        public V get(Object key) {
            int index = indexOfKey(key);
            if (map[index] == null) {
               return null;
            }
            LinkedList<MapEntry<K,V>> list = map[index];
            for (Entry<K,V> entry : list) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
            return null;
        }

        private int indexOfKey(Object key) {
            return Math.abs(key.hashCode()) % capacity;
        }
    }

    public static void main(String[] args) {
        new Tester(SimpleMap.class,Ex37.tests).run();
        new Tester(SimpleHashMap.class,Ex37.tests).run();
    }
}
