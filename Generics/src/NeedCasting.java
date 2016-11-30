import apple.laf.JRSUIConstants;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by belows on 2016/11/14.
 */
public class NeedCasting {
//    @SuppressWarnings("unchecked")
    public static void f(String[] args) throws Exception {

        List<String> test = new ArrayList<>();
        for (int i=0; i<30; ++i) {
            test.add("Test" + i);
        }

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("11.text"));
        out.writeObject(test);

        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("11.text"));
        List<Integer> t2 = null;
        t2 = List.class.cast(in.readObject());
        t2.get(0).toString();
        System.out.println(test);

    }

    public static void main(String[] args) throws Exception {
        f(args);
    }

}
