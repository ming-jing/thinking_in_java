import ex5.T;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by belows on 2016/10/19.
 */

class T16 {
    int size ;
    T16(int size ) {
        this.size = size;
    }

    CharSequence getChars() {
        char[] cs = new char[size];
        Random random = new Random();
        for (int i=0; i<cs.length; ++i) {
            cs[i] = (char)('a' + random.nextInt(26));
        }
        return new String(cs);
    }
}

class Adapter implements Readable {
    T16 t16;
    int n;
    Adapter(int n, T16 t16) {
        this.n = n;
        this.t16 = t16;
    }

    @Override
    public int read(@NotNull CharBuffer cb) throws IOException {
        if (n-- == 0) {
            return -1;
        }
        cb.append(t16.getChars());
        cb.append(" ");
        return t16.size + 1;
    }
}

class RandomWords implements Readable {
    private static Random rand = new Random(47);
    private static final char[] capitals =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] lowers =
            "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] vowels =
            "aeiou".toCharArray();
    private int count;
    public RandomWords(int count) { this.count = count; }
    public int read(CharBuffer cb) {
        if(count-- == 0)
            return -1; // Indicates end of input
        cb.append(capitals[rand.nextInt(capitals.length)]);
        for(int i = 0; i < 4; i++) {
            cb.append(vowels[rand.nextInt(vowels.length)]);
            cb.append(lowers[rand.nextInt(lowers.length)]);
        }
        cb.append(" ");
        return 10; // Number of characters appended
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomWords(10));
        while(s.hasNext())
            System.out.println(s.next());
    }
}

public class Ex16 {
    public static void main(String[] args) {
       Adapter adapter = new Adapter(2,new T16(30));
        Scanner scanner = new Scanner(adapter);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }

//        RandomWords.main(args);
    }
}
