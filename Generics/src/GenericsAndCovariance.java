import java.util.ArrayList;
import java.util.List;

/**
 * Created by belows on 2016/11/11.
 */
public class GenericsAndCovariance {
    public static void main(String[] args) {
        // Wildcards allow covariance:
        List<? super Apple> flist = new ArrayList<Apple>();
        // Compile Error: can’t add any type of object:
//         flist.add(new Apple());
//         flist.add(new Fruit());
//         flist.add(new Object());
        flist.add(null); // Legal but uninteresting
        // We know that it returns at least Fruit:
        Object f = flist.get(0);
    }
}