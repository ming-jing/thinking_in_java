import java.util.Scanner;

/**
 * Created by belows on 2016/11/3.
 */
public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pattern = "[A-Z].*\\.";
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.matches(pattern)) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }
    }
}
