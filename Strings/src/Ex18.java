import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by belows on 2016/11/5.
 */
public class Ex18 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String reg = "\".*\"";
        Matcher m = Pattern.compile(reg).matcher("");

        while (scanner.hasNext()) {
            String file = scanner.nextLine();
            String input = null;
            if (Files.isDirectory(Paths.get(file), LinkOption.NOFOLLOW_LINKS)) {
                input = Ex16.readDir(file);
            } else {
                input = Ex16.readFile(file);
            }
            m.reset(input);
            while (m.find()) {
                System.out.println(m.group());
            }
        }
    }
}
