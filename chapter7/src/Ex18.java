import java.util.Random;

/**
 * Created by beta on 16-10-2.
 */

public class Ex18 {
    static final int i = new Random().nextInt();
    final int j = new Random().nextInt();

    public static void main(String[] args) {
        Ex18 e = new Ex18();
        System.out.println(e.i + ": " + e.j);
        e = new Ex18();
        System.out.println(e.i + ": " + e.j);
    }
}
