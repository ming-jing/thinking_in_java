import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by belows on 2016/11/30.
 */
public class Ex13 {
    public static class AssociativeArray<K,V> {
        int mCapability = 16;
        int mSize = 0;
        Object[][] mData = new Object[mCapability][2];

        public K[] keys() {
            Object[] keys = new Object[mSize];
            for (int i=0; i<mSize; ++i) {
                keys[i] = mData[i][0];
            }
            return (K[])keys;
        }

        public V[] values() {
            Object[] values = new Object[mSize];
            for(int i=0; i<mSize; ++i) {
                values[i] = mData[i][1];
            }
            return (V[]) values;
        }

        public void put(K key, V value) {
            if (isFull()) {
                expandSize(mSize<<1);
            }

            int index = contain(key);
            if (index >= 0) {
                mData[index][0] = key;
                mData[index][1] = value;
            } else {
                mData[mSize][0] = key;
                mData[mSize][1] = value;
                ++mSize;
            }
        }

        public int contain(K key) {
            for (int i=0; i<mSize; ++i) {
                if (mData[i][0].equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        public V get(K key) {
            for (int i=0; i<mSize; ++i) {
                if (key.equals(mData[i][0])) {
                    return (V) mData[i][1];
                }
            }
            return null;
        }

        private boolean isFull() {
            if (mSize >= mCapability) {
                return true;
            }
            return false;
        }

        private void expandSize(int newSize) {
            Object[][] data = new Object[newSize][2];
            System.arraycopy(mData,0,data,0,mSize);
            mCapability = newSize;
            mData = data;
        }

        public void clear() {
            for (int i=0; i<mSize; ++i) {
                mData[i][0] = null;
                mData[i][1] = null;
            }
            mSize = 0;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();

            builder.append("[");
            for (int i=0; i<mSize; ++i) {
                builder.append("(");
                builder.append(mData[i][0]);
                builder.append(",");
                builder.append(mData[i][1]);
                builder.append(")");
            }
            builder.append("]");
            return builder.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        AssociativeArray<String,Integer> map = new AssociativeArray<>();

        while (scanner.hasNextLine()) {
            map.clear();
            String fileName = scanner.nextLine();
            Scanner fileScanner = new Scanner(new FileInputStream(fileName));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] words = line.split("[^A-Z&^a-z&^0-9&^_]+");

                for (String word : words) {
                    Integer v =  map.get(word);
                    if (v != null) {
                        map.put(word,v+1);
                    } else {
                        map.put(word,1);
                    }
                }
            }
            System.out.println(map);
        }

    }
}
