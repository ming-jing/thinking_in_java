import java.util.Random;

/**
 * Created by beta on 16-9-28.
 */
class Tank {
    boolean filled = false;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (filled) {
            System.out.println("tank filled");
        }
    }
}

public class Ex12 {
    public static void main(String[] args) {
        while (true) {
            Tank tank = new Tank();
            tank.filled = new Random().nextBoolean();
        }
    }
}
