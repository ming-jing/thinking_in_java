import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by belows on 2016/11/29.
 */
public class Ex10 {

    private static class SortSet<T> implements Set<T>{

        private LinkedList<T> mData = new LinkedList<T>();

        @Override
        public int size() {
            return mData.size();
        }

        @Override
        public boolean isEmpty() {
            return mData.isEmpty();
        }

        @Override
        public boolean contains(Object o) {
            return mData.contains(o);
        }

        @NotNull
        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                int index = 0;
                @Override
                public boolean hasNext() {
                    return index < size();
                }

                @Override
                public T next() {
                    return mData.get(index++);
                }
            };
        }

        @NotNull
        @Override
        public Object[] toArray() {
            return mData.toArray();
        }

        @NotNull
        @Override
        public <T1> T1[] toArray(@NotNull T1[] a) {
            return mData.toArray(a);
        }

        @Override
        public boolean add(T t) {
            if (contains(t)) {
                return false;
            }
            return mData.add(t);
        }

        @Override
        public boolean remove(Object o) {
            return mData.remove(o);
        }

        @Override
        public boolean containsAll(@NotNull Collection<?> c) {
            return mData.containsAll(c);
        }

        @Override
        public boolean addAll(@NotNull Collection<? extends T> c) {
            return mData.addAll(c);
        }

        @Override
        public boolean retainAll(@NotNull Collection<?> c) {
            return mData.retainAll(c);
        }

        @Override
        public boolean removeAll(@NotNull Collection<?> c) {
            return mData.removeAll(c);
        }

        @Override
        public void clear() {
            mData.clear();
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i=0; i<size(); ++i) {
                builder.append(mData.get(i));
                builder.append(" ");
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        SortSet<String> ss = new SortSet<>();
        for (int i=0; i<10; ++i) {
            ss.add("Test" + i);
        }
        for (int i=0; i<10; ++i) {
            ss.add("Test" + i);
        }
        System.out.println(ss);
    }
}
