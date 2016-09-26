import java.util.Random;

/**
 * Created by beta on 16-9-25.
 */
public class Ex2 {
    public static void main(String[] args) {
        Random random = new Random(47);
        int pre = random.nextInt();
        for (int i = 1; i < 25; ++i) {
            int current = random.nextInt();
            System.out.print(current + "    ");
            if (pre > current) {
                System.out.println(pre + ">" + current);
            } else if (pre == current) {
                System.out.println(pre + "==" + current);
            } else {
                System.out.println(pre + "<" + current);
            }
            pre = current;
        }
    }
}
