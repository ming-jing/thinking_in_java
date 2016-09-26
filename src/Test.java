import java.io.IOException;

/**
 * Created by beta on 16-8-14.
 */

class T {

    static final int i = 3;

    static {
        System.out.println("Init");
    }
}

public class Test {

    public static void main(String[] args) throws IOException {
        int k = T.i;
        Class t = T.class;
//        try{
//            Class c = Class.forName("T");
//        } catch (Exception e) {}
        Class<? super String> k1 = String.class;
        k1 = Object.class;

    }
}
