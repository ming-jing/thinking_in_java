import java.io.IOException;
import java.util.Scanner;
import java.util.jar.Pack200;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by belows on 2016/11/5.
 */
public class Ex17 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String reg = "(?m)(((?s)/\\*.*?\\*/)|\\s+//.*$)";
        Matcher m = Pattern.compile(reg).matcher("");
        while(scanner.hasNext()) {
            String file = scanner.nextLine();
            String input = Ex16.readFile(file);
            m.reset(input);
            StringBuilder builder = new StringBuilder();
            while (m.find()) {
                builder.append(m.group());
                builder.append("\n");
            }
            System.out.println(builder.toString());
        }
    }
}
