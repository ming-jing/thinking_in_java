import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Created by belows on 2016/11/9.
 */
public class Ex17 {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Pattern p = Pattern.compile("\\w+\\.|native |final ");

        while (line != null) {
            Class cls = Class.forName(line);
            Method[] methods = cls.getMethods();
            for (Method method : methods) {
                System.out.println(p.matcher(method.toString()).replaceAll(""));
            }
            line = br.readLine();
        }
    }
}
