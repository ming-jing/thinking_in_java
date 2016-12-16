import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Created by belows on 2016/12/6.
 */
public class SlowSet<T> implements Set<T> {

    List<T> list = new ArrayList<T>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @NotNull
    @Override
    public Object[] toArray() {
        Object[] rs = new Object[list.size()];
        for (int i=0; i<list.size(); ++i) {
            rs[i] = list.get(i);
        }
        return rs;
    }

    @NotNull
    @Override
    public <T1> T1[] toArray(@NotNull T1[] a) {
        Object[] array = toArray();
        return (T1[]) array;
    }

    @Override
    public boolean add(T t) {
        if (contains(t)) {
            return false;
        }
        list.add(t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends T> c) {

        boolean b = false;
        for ( T t : c) {
            if(add(t)) {
                b = true;
            }
        }
        return b;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        boolean b = false;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            T t = it.next();
            if (!c.contains(t)) {
                it.remove();
                b = true;
            }
        }
        return b;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        Set<Integer> set = new SlowSet<>();
        for (int i=0; i<21; ++i) {
            if (i%2==0) {
                set.add(i);
            } else {
                set.add(++i);
            }
        }

        Set<Integer> s2 = new SlowSet<>();
        for (int i=0; i<10; ++i) {
            s2.add(i);
        }
        set.retainAll(s2);

        System.out.println(set);

        ArrayList<Integer> itest = new ArrayList<>();
        for (int i=0; i<10; ++i) {
            itest.add(i);
        }
        int index = 0;
        for (int i=0;i<itest.size(); ++i) {

            if (i %2 == 0) {
                itest.remove(itest.get(i));
            }
        }
        System.out.println(itest);
    }
}
