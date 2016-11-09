import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by belows on 2016/11/9.
 */
public class Ex18 {
    public static class Test {}

    static class T {}

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Class cls = Class.forName(line);
            Constructor[] cs = cls.getConstructors();
            for (Constructor con: cs) {
                System.out.println(con);
            }
        }
    }
}
