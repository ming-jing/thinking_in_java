import java.util.*;

/**
 * Created by belows on 2016/10/25.
 */


interface Generator<T> {
    T next();
}

public class Ex4 implements Generator<String>{

    String[] characters = {
            "Grumpy", "Happy", "Sleepy", "Dopey", "Doc", "Sneezy",
            "Bashful", "Snow White", "Witch Queen", "Prince"
    };
    private int index = 0;
    @Override
    public String next() {
        int actualIndex = index++ % characters.length;
        return characters[actualIndex];
    }

    public void fill(Collection<String> c, int size) {
        for (int i=0; i<size; ++i) {
            c.add(next());
        }
    }

    private void reset() {
        index = 0;
    }

    public static void main(String[] args) {
        final int size = 10;
        Ex4 e = new Ex4();
        String[] sa = new String[size];
        for (int i=0; i<size; ++i) {
            sa[i] = e.next();
        }
        System.out.println(Arrays.toString(sa));
        e.reset();
        Collection<String> c = new ArrayList<>();
        e.fill(c,size);
        System.out.println(c);
        e.reset();
        c = new LinkedList<>();
        e.fill(c,size);
        System.out.println(c);
        e.reset();
        c = new HashSet<>();
        e.fill(c,size);
        System.out.println(c);
        e.reset();
        c = new TreeSet<>();
        e.fill(c,size);
        System.out.println(c);
        e.reset();
        c = new LinkedHashSet<>();
        e.fill(c,size);
        System.out.println(c);
        e.reset();
    }
}
