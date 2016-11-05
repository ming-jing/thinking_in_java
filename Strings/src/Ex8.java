import java.util.Arrays;

/**
 * Created by belows on 2016/11/3.
 */
public class Ex8 {
    public static void main(String[] args) {
         String knights =
                "Then, when you have found the shrubbery, you must " +
                        "cut down the mightiest tree in the forest... " +
                        "with... a herring!";
        String pattern = "the|you";
        String[] words = knights.split(pattern);
        for (String s : words) {
            System.out.println(s);
        }
    }
}
