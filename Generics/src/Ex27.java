import java.util.ArrayList;
import java.util.List;

/**
 * Created by belows on 2016/11/11.
 */
public class Ex27 {
    public static void main(String[] args) {
        List<? extends Number> numbers = new ArrayList<Integer>();
        Number number
         = numbers.get(0);
    }
}
