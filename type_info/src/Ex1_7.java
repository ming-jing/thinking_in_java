/**
 * Created by beta on 16-8-31.
 */
class Candy {
    Candy() {
        System.out.println("Candy Init");
    }
}

class Apple {
    Apple() {
        System.out.println("Apple Init");
    }
}

public class Ex1_7 {
    public static void main(String[] args) {
        for (String s : args) {
            try {
                Class c = Class.forName(s);
                c.newInstance();
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {
            } catch (ClassNotFoundException e) {
            }
        }
    }

}
