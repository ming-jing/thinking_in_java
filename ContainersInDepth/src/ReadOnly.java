import java.util.*;

/**
 * Created by belows on 2016/12/15.
 */
public class ReadOnly {
    static Collection<String> data =
            new ArrayList<String>(StrGenerator.names(6));
    public static void main(String[] args) {
        Collection<String> c =
                Collections.unmodifiableCollection(
                        new ArrayList<String>(data));
        System.out.println(c); // Reading is OK
//        c.add("one"); // Can’t change it
        List<String> a = Collections.unmodifiableList(new ArrayList<String>(data));
        ListIterator<String> lit = a.listIterator();
        System.out.println(lit.next()); // Reading is OK
        //lit.add("one"); // Can’t change it
        Set<String> s = Collections.unmodifiableSet(
                new HashSet<String>(data));
        System.out.println(s); // Reading is OK
        //! s.add("one"); // Can’t change it
        // For a SortedSet:
        Set<String> ss = Collections.unmodifiableSortedSet(
                new TreeSet<String>(data));
        Map<String,String> m = Collections.unmodifiableMap(
                new HashMap<String,String>(StrGenerator.capitals(6)));
        System.out.println(m); // Reading is OK
        //! m.put("Ralph", "Howdy!");
        // For a SortedMap:
        
        Map<String,String> sm =
                Collections.unmodifiableSortedMap(
                        new TreeMap<String,String>(StrGenerator.capitals(6)));
    }

    private static class StrGenerator {
        private static Random random = new Random(47);
        private static final char[] cs = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        public static String create(int len) {
            char[] rs = new char[len];
            for (int i=0; i<len; ++i) {
                rs[i] = cs[random.nextInt(cs.length)];
            }
            return new String(rs);
        }

        public static Collection<String> names(int size) {
             List<String> names = new ArrayList<>(size);
            for (int i=0; i<size; ++i) {
                names.add(create(5));
            }
            return names;
        }

        public static Map<String,String> capitals(int size) {
            Map<String,String> map = new HashMap<>(size);
            for (int i=0; i<size; ++i) {
                map.put(create(5),create(5));
            }
            return map;
        }
    }
} 
