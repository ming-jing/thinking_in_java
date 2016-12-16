import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by belows on 2016/12/7.
 */
public class Ex26 {
    public static class CountedString {
        private static List<String> created =
                new ArrayList<>();
        private static List<Character> cList = new ArrayList<>();

        private String s;
        private char c;
        private int id = 0;

        public CountedString(String str, char c) {
            s = str;
            this.c = c;
            created.add(s);
            cList.add(c);
            // id is the total number of instances
            // of this string in use by CountedString:
            for (String s2 : created)
                if (s2.equals(s)) {
                    for (char c1 : cList) {
                        if (c1 == c) {
                            id++;
                        }
                    }
                }
        }

        public String toString() {
            return "String: " + s + " id: " + id +
                    " hashCode(): " + hashCode();
        }

        public int hashCode() {
            // The very simple approach:
            // return s.hashCode() * id;
            // Using Joshua Bloch’s recipe:
            int result = 17;
            result = 37 * result + s.hashCode();
            result = 37 * result + Character.hashCode(c);
            result = 37 * result + id;
            return result;
        }

        public boolean equals(Object o) {
            return o instanceof CountedString &&
                    s.equals(((CountedString) o).s) &&
                    c == ((CountedString)o).c &&
                    id == ((CountedString) o).id;
        }

        public static void main(String[] args) {
            Map<CountedString, Integer> map =
                    new HashMap<>();
            CountedString[] cs = new CountedString[5];
            for (int i = 0; i < cs.length; i++) {
                cs[i] = new CountedString("hi",'c');
                map.put(cs[i], i); // Autobox int -> Integer
            }
            System.out.println(map);
            for (CountedString cstring : cs) {
                System.out.println("Looking up " + cstring);
                System.out.println(map.get(cstring));
            }
        }
    }
}
