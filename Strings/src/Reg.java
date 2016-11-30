import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by belows on 2016/11/18.
 */
public class Reg {
    public static void main(String[] args) {
            String s = "http://www.baidu.com/index/tests/test?i=3";
            Scanner scanner = new Scanner(System.in);
                while (scanner.hasNextLine()) {
                    try {

                        String line = scanner.nextLine();
                    Matcher matcher = Pattern.compile(line).matcher(s);
                        System.out.println(matcher.find());
                    if (matcher.groupCount() > 0) {
                        System.out.println(matcher.group(1));
                    } else {
                        System.out.println(false);
                    }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }

    }
}
