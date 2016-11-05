import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by belows on 2016/11/5.
 */
public class Ex14 {
    static class SplitDemo {
        public static void main(String[] args) {
            String input =
                    "This!!unusual use!!of exclamation!!points";
            System.out.println(Arrays.toString(
                    Pattern.compile("!!").split(input)));
            // Only do the first three:
            System.out.println(Arrays.toString(
                    Pattern.compile("!!").split(input, 3)));

            System.out.println(Arrays.toString(input.split("!!")));
            System.out.println(Arrays.toString(input.split("!!",3)));
        }
    }
    
    public static void main(String[] args) {
        SplitDemo.main(args);
    }
}
