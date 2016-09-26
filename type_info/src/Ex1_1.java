/**
 * Created by beta on 16-8-31.
 */
class Toy {
    private Toy() {
    }

    public Toy(int i) {
    }
}

public class Ex1_1 {

    public static void main(String[] args) {
        try {
            Class c = Class.forName("Toy");
            c.newInstance();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
