package ex31;

/**
 * Created by belows on 2016/12/14.
 */
public class Container<T> {
    private Object[] mData;
    private int size;
    public Container() {
        mData = new Object[16];
    }

    public void clear() {
        for (int i=0; i<size; ++i) {
            mData[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    private void checkRange(int index) {
        if (index <0 || index>=size) {
            throw new IllegalStateException("wrong index:" + index +",size:" + size);
        }
    }

    public T get(int index) {
        checkRange(index);
        return (T)mData[index];
    }

    public void add(T t) {
        if (!placeEnough()) {
            expandSize(size << 1);
        }
        mData[size++] = t;
    }

    private boolean placeEnough() {
        return size < mData.length;
    }

    private void expandSize(int newSize) {
        Object[] data = new Object[newSize];
        System.arraycopy(mData,0,data,0,size);
        mData = data;
    }
}
