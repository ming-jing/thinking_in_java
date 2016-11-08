import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by belows on 2016/11/7.
 */
public class Ex9 {

    public static void fields(Object obj) {

    }

    public static void fields(Class c) {
        System.out.println(Arrays.toString(c.getDeclaredFields()));
        System.out.println(Arrays.toString(c.getFields()));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            try {
                fields(Class.forName(scanner.nextLine()));
            } catch (ClassNotFoundException e) {}
        }
    }
}
