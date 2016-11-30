import java.util.*;

/**
 * Created by belows on 2016/11/28.
 */
public class CountingMapData
        extends AbstractMap<Integer,String> {
    private int size;
    private static String[] chars =
            "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z"
                    .split(" ");
    public CountingMapData(int size) {
        if(size < 0) this.size = 0;
        this.size = size;
    }
    private static class Entry
            implements Map.Entry<Integer,String> {
        int index;
        Entry(int index) { this.index = index; }
        public boolean equals(Object o) {
            return Integer.valueOf(index).equals(o);
        }
        public Integer getKey() { return index; }
        public String getValue() {
            return
                    chars[index % chars.length] +
                            Integer.toString(index / chars.length);
        }
        public String setValue(String value) {throw new UnsupportedOperationException();
        }
        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }
    }

    private static class EntrySet extends AbstractSet<Map.Entry<Integer,String>> {

        private int size;

        EntrySet(int size) {
            this.size = size;
        }

        @Override
        public Iterator<Map.Entry<Integer, String>> iterator() {

            return new Iterator<Map.Entry<Integer, String>>() {
                int index = 0;
                Entry entry = new Entry(-1);

                @Override
                public boolean hasNext() {
                    return index < size;
                }

                @Override
                public Map.Entry<Integer, String> next() {
                    index++;
                    entry.index++;
                    return entry;
                }
            };
        }

        @Override
        public int size() {
            return size;
        }
    }
//    public Set<Map.Entry<Integer,String>> entrySet() {
//        // LinkedHashSet retains initialization order:
//        Set<Map.Entry<Integer,String>> entries =
//                new LinkedHashSet<Map.Entry<Integer,String>>();
//        for(int i = 0; i < size; i++)
//            entries.add(new Entry(i));
//        return entries;
//    }


    @Override
    public Set<Map.Entry<Integer, String>> entrySet() {
        return new EntrySet(size);
    }

    public static void main(String[] args) {
        System.out.println(new CountingMapData(60));
    }
}
