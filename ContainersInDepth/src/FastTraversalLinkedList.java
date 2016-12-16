import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by belows on 2016/12/14.
 */
class FastTraversalLinkedList<T> extends AbstractList<T> {
    private class FlaggedArrayList {
        private FlaggedLinkedList companion;
        boolean changed = false;
        private ArrayList<T> list = new ArrayList<T>();

        public void addCompanion(FlaggedLinkedList other) {
            companion = other;
        }

        private void synchronize() {
            if (companion.changed) {
                list = new ArrayList<T>(companion.list);
                companion.changed = false;
            }
        }

        public T get(int index) {
            synchronize();
            return list.get(index);
        }

        public int size() {
            synchronize();
            return list.size();
        }

        public T remove(int index) {
            synchronize();
            changed = true;
            return list.remove(index);
        }

        public boolean remove(Object item) {
            synchronize();
            changed = true;
            return list.remove(item);
        }

        // Always broadcasted to the companion container, too.
        public void clear() {
            list.clear();
            changed = false;
        }
    }

    private class FlaggedLinkedList {
        private FlaggedArrayList companion;
        boolean changed = false;
        LinkedList<T> list = new LinkedList<T>();

        public void addCompanion(FlaggedArrayList other) {
            companion = other;
        }

        private void synchronize() {
            if (companion.changed) {
                list = new LinkedList<T>(companion.list);
                companion.changed = false;
            }
        }

        public void add(int index, T item) {
            synchronize();
            changed = true;
            list.add(index, item);
        }

        public boolean add(T item) {
            synchronize();
            changed = true;
            return list.add(item);
        }

        public Iterator<T> iterator() {
            synchronize();
            return list.iterator();
        }

        // Always broadcasted to the companion container, too.
        public void clear() {
            list.clear();
            changed = false;
        }
    }

    private FlaggedArrayList aList =
            new FlaggedArrayList();
    private FlaggedLinkedList lList =
            new FlaggedLinkedList();

    // Connect the two so they can synchronize:
    {
        aList.addCompanion(lList);
        lList.addCompanion(aList);
    }

    public int size() {
        return aList.size();
    }

    public T get(int arg) {
        return aList.get(arg);
    }

    public void add(int index, T item) {
        lList.add(index, item);
    }

    public boolean add(T item) {
        return lList.add(item);
    }

    // Through testing, we discovered that the ArrayList is
// actually much faster for removals than the LinkedList:
    public T remove(int index) {
        return aList.remove(index);
    }

    public boolean remove(Object item) {
        return aList.remove(item);
    }

    public Iterator<T> iterator() {
        return lList.iterator();
    }

    public void clear() {
        aList.clear();
        lList.clear();
    }
}
