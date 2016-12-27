package ex.test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by belows on 2016/12/14.
 */
public class FastList<T> extends AbstractList<T> {

    private ArrayList<T> arrayList = new ArrayList<T>();
    private LinkedList<T> linkedList = new LinkedList<T>();
    private boolean arrayChanged = false;
    private boolean linkChanged = false;

    private void synchronizeArray() {
        if (linkChanged) {
            arrayList = new ArrayList<T>(linkedList);
            linkChanged = false;
        }
    }

    private void synchronizeLink() {
        if (arrayChanged) {
            linkedList = new LinkedList<T>(arrayList);
            arrayChanged = false;
        }
    }

    FastList() {}

    @Override
    public boolean add(T t) {
        synchronizeLink();
        linkChanged = true;
        return linkedList.add(t);
    }

    @Override
    public void add(int index, T element) {
        synchronizeLink();
        linkChanged = true;
        linkedList.add(index,element);
    }

    @Override
    public T get(int index) {
        synchronizeArray();
        return arrayList.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return linkedList.iterator();
    }

    @Override
    public void clear() {
        arrayList.clear();
        linkedList.clear();
        arrayChanged = false;
        linkChanged = false;
    }

    @Override
    public boolean remove(Object o) {
        synchronizeArray();
        arrayChanged = true;
        return arrayList.remove(o);
    }

    @Override
    public T remove(int index) {
        synchronizeArray();
        arrayChanged = true;
        return arrayList.remove(index);
    }

    @Override
    public int size() {
        synchronizeArray();
        return arrayList.size();
    }

    @Override
    public String toString() {
        synchronizeArray();
        return arrayList.toString();
    }
}
