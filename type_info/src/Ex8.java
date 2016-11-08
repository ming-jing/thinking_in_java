import java.util.Scanner;

/**
 * Created by belows on 2016/11/7.
 */
public class Ex8 {

    public static void hierarchy(Object obj) {
        hierarchy(obj.getClass());
    }

    public static void hierarchy(Class base) {
        if (base == null) {
            return;
        } else {
            System.out.println(base.getName());
            hierarchy(base.getSuperclass());
        }
    }

    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        System.out.println(Scanner.class.getName());
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            try {
                Class c = Class.forName(line);
                hierarchy(c);
            } catch (ClassNotFoundException e) {}

        }
    }
}
