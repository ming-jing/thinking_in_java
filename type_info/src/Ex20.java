import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

/**
 * Created by belows on 2016/11/9.
 */
public class Ex20 {
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Class cls = Class.forName(line);
            Method[] methods = cls.getMethods();
            for (Method m : methods) {
                System.out.println(m);
            }
        }
    }
}
