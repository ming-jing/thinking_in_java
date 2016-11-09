import java.lang.reflect.Constructor;
import java.util.Scanner;

/**
 * Created by belows on 2016/11/9.
 */
public class Ex19 {
    public static class Toy {
        int iq;
        public Toy(int iq) {
            this.iq = iq;
        }

        @Override
        public String toString() {
            return "Toy, iq:" + iq;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println(int.class);
        System.out.println(Integer.class);
        while (scanner.hasNext()) {
            String name = scanner.next();
            int iq = 0;
            if (scanner.hasNext()) {
                iq = scanner.nextInt();
            }
            Class cls = Class.forName(name);
            Constructor con = cls.getConstructor(int.class);
            Object obj = con.newInstance(iq);
            System.out.println(obj);
        }
    }
}
