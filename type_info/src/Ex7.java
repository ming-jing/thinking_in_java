import java.util.Scanner;

/**
 * Created by belows on 2016/11/7.
 */
public class Ex7 {

    static class Candy {
        static { System.out.println("Loading Candy"); }
        Candy() {
            System.out.println("Candy Created");
        }
    }
    static class Gum {
        static { System.out.println("Loading Gum"); }
        Gum() {
            System.out.println("Gum Created");
        }
    }
    static class Cookie {
        static { System.out.println("Loading Cookie"); }
        Cookie() {
            System.out.println("Cookie Created");
        }
    }
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Class c = Candy.class;
        System.out.println(c.getName());
        while (scanner.hasNext()) {
            String line = scanner.next();
            try {
                Class c1 = Class.forName(line);
                Object object = c1.newInstance();
            } catch (ClassNotFoundException e) {}
            catch (InstantiationException e) {}
            catch (IllegalAccessException e) {}
        }
    }
}
