import java.io.FileInputStream;
import java.util.*;

/**
 * Created by belows on 2016/12/6.
 */
public class SimpleHashMap<K,V> extends AbstractMap<K,V>{

    final int size = 1024;
    LinkedList<MapEntry<K,V>>[] map = new LinkedList[size];

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public V put(K key, V value) {
        int index = indexOfKey(key);
        if (map[index] == null) {
            map[index] = new LinkedList<>();
        } else {
//            System.out.println("key:" + key + "value:" + value + " collisions at " + index);
        }
        LinkedList<MapEntry<K,V>> list = map[index];
        V old = null;
        boolean found = false;
        for (MapEntry<K,V> entry : list) {
            if (key.equals(entry.getKey())) {
                old = entry.getValue();
                entry.setValue(value);
                found = true;
                break;
            }
        }
        if (!found) {
            list.add(new MapEntry<K, V>(key,value));
        }
        return old;
    }

    @Override
    public V get(Object key) {
            int index = indexOfKey(key);
        LinkedList<MapEntry<K,V>> list = map[index];
        if (list == null) {
            return null;
        }
        int steps = 0;
        for(MapEntry<K,V> entry : list) {
            ++steps;
            if (key.equals(entry.getKey())) {
//                System.out.println("probes:" + steps);
                return entry.value;
            }
        }

        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        HashSet<Entry<K,V>> sets = new HashSet<>();
        for (LinkedList<MapEntry<K,V>> list : map) {
            if (list != null) {
                for(MapEntry<K,V> entry : list) {
                    sets.add(entry);
                }
            }
        }
        return sets;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (LinkedList<MapEntry<K,V>> list : map) {
            if (list != null) {
                for(MapEntry<K,V> entry : list) {
                    builder.append("[");
                    builder.append(entry.getKey());
                    builder.append("-");
                    builder.append(entry.getValue());
                    builder.append("]");
                    builder.append(",");
                }
            }
        }
        builder.append("}");
        return builder.toString();
    }

    @Override
    public void clear() {
        for(LinkedList<MapEntry<K,V>> list : map) {
            if (list!= null) {
                list.clear();
            }
        }
    }

    @Override
    public boolean remove(Object key, Object value) {
        for (LinkedList<MapEntry<K,V>> list : map) {
            if (list != null) {
                Iterator<MapEntry<K,V>> it = list.iterator();
                while (it.hasNext()) {
                    MapEntry<K,V> entry = it.next();
                    if (key.equals(entry.getKey()) && value.equals(entry.getValue())) {
                        it.remove();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int indexOfKey(Object key) {
        return Math.abs(key.hashCode()) % size;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            while (scanner.hasNextLine()) {
                String fileName = scanner.nextLine();
                SimpleHashMap<String,Integer> map = new SimpleHashMap<>();
                Scanner fileScanner = new Scanner(new FileInputStream(fileName));
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] words = line.split("[^a-z&^A-Z&^0-9&^_]+");
                    for (String word : words) {
                        Integer i = map.get(word);
                        if (i == null ) {
                            map.put(word,1);
                        } else {
                            map.put(word,i+1);
                        }
                    }
                }
//                System.out.println(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println(e);
        }
    }
}
