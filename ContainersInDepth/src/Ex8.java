import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Created by belows on 2016/11/29.
 */
public class Ex8 {
    private static class SList<T> {
        private Object[] mData;
        private int mSize;
        private int mCapability;

        public SList() {
            this(16);
        }

        public SList(int capability) {
            mSize = 0;
            mCapability = capability;
            mData = new Object[mCapability];
        }

        private boolean isFull() {
            return mSize >= mCapability;
        }

        private void expandCapability(int newSize) {
            Object[] data = new Object[newSize];
            System.arraycopy(mData,0,data,0,mData.length);
            mCapability = newSize;
            mData = data;
        }

        private void expandCapability() {
            int newSize = mCapability << 1;
            expandCapability(newSize);
        }

        public SListIterator iterator() {
            return new SListIterator();
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            for (int i=0; i<mSize; ++i) {
                builder.append(mData[i]);
                builder.append(",");
            }
            builder.append("]");
            return builder.toString();
        }

        public class SListIterator implements Iterator<T> {

            int index = 0;
            @Override
            public boolean hasNext() {
                return index < mSize;
            }

            @Override
            public T next() {
                return (T)mData[index++];
            }

            public void add(T t) {
                if (isFull()) {
                    expandCapability();
                }
                if (index == mSize) {
                    mData[index] = t;
                } else {
                    System.arraycopy(mData,index,mData,index+1,mSize-index);
                    mData[index] = t;
                }
                ++mSize;
            }

            public void remove() {
                System.arraycopy(mData,index+1,mData,index,mSize-index);
                --mSize;
            }
        }
    }

    public static void main(String[] args) {
        SList<Integer> s = new SList<>();
        SList.SListIterator sIter = s.iterator();
        for (int i=0; i<20; ++i) {
            sIter.add(i);
            sIter.next();
        }

        sIter = s.iterator();
        while (sIter.hasNext()) {
            System.out.print(sIter.next() + " ");
        }
        System.out.println();
     }
}
