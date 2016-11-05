/**
 * Created by belows on 2016/11/3.
 */
public class Ex9 {
    public static void main(String[] args) {
         String knights =
                "Then, when you have found the shrubbery, you must " +
                        "cut down the mightiest tree in the forest... " +
                        "with... a herring!";
        String pattern = "[aeiouAEIOU]";
        String r = knights.replaceAll(pattern,"_");
        System.out.println(r);
    }
}
