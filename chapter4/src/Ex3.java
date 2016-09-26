import java.util.Random;
import java.util.Scanner;

/**
 * Created by beta on 16-9-25.
 */
public class Ex3 {
    public static void main(String[] args) {
        Random random = new Random(47);
        Scanner scanner = new Scanner(System.in);
        int pre = random.nextInt();
        while (scanner.hasNext()) {
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
            scanner.next();
        }
    }
}
