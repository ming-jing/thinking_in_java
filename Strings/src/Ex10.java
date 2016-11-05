import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by belows on 2016/11/4.
 */
public class Ex10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String test = scanner.nextLine();

        while (scanner.hasNext()) {
            String reg = scanner.next();
            Pattern p = Pattern.compile(reg);
            Matcher matcher = p.matcher(test);
            if (matcher.find()) {
                System.out.println(matcher.groupCount());
            } else {
                System.out.println(false);
            }
        }
    }
}
