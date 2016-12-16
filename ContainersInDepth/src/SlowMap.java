import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Created by belows on 2016/12/6.
 */

class MapEntry<K,V> implements Map.Entry<K,V> {

    K key;
    V value;

    MapEntry(K key, V value) {
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
        V result = this.value;
        this.value = value;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MapEntry)) {
            return false;
        }
        MapEntry<K,V> other = (MapEntry) o;
        return ((key==null)?other.key==null:key.equals(other.key)) &&
                ((value==null?other.value==null:value.equals(other.value)));
    }

    @Override
    public int hashCode() {
        return (key==null?0:key.hashCode())
                ^ (value==null?0:value.hashCode());
    }
}

public class SlowMap<K,V> implements Map<K,V> {

//    List<K> keys = new ArrayList<K>();
//    List<V> values = new ArrayList<V>();
    HashSet<Entry<K,V>> set = new HashSet<>();

    @Override
    public Set<Entry<K, V>> entrySet() {
        return set;
    }

    public V put(K key, V value) {
        V old =  null;

        boolean hasKey = false;
        for (Entry<K,V> entry : set) {
            if (key.equals(entry.getKey())) {
                old = entry.getValue();
                entry.setValue(value);
                hasKey = true;
                break;
            }
        }

        if (!hasKey) {
            Entry<K,V> entry = new MapEntry<K, V>(key,value);
            set.add(entry);
        }

        return old;
    }

    @Override
    public V get(Object key) {

        for (Entry<K,V> entry : set) {
            if (key.equals(entry.getKey())) {
                return entry.getValue();
            }
        }

        return null;
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        for (Entry<K,V> entry : set) {
            if (key.equals(entry.getKey())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Entry<K,V> entry : set) {
            if (value.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V remove(Object key) {
        Iterator<Entry<K,V>> it = set.iterator();
        while (it.hasNext()) {
            Entry<K,V> entry = it.next();
            if (key.equals(entry.getKey())) {
                it.remove();
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public void putAll(@NotNull Map<? extends K, ? extends V> m) {
        for (Entry<? extends K,? extends V> entry : m.entrySet()) {
            put(entry.getKey(),entry.getValue());
        }
    }

    @Override
    public void clear() {
        set.clear();
    }

    @NotNull
    @Override
    public Set<K> keySet() {
        return null;
    }

    @NotNull
    @Override
    public Collection<V> values() {
        return null;
    }
}
