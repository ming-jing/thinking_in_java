import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by belows on 2016/11/9.
 */
public class Test {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        while (line != null) {
            Class cls = Class.forName(line);
            Method[] methods = cls.getMethods();
            Constructor[] constructors = cls.getConstructors();
//            for (Method m: methods) {
//                System.out.println(m.toString());
//            }
            for (Constructor c :constructors) {
                System.out.println(c);
            }
            line = br.readLine();
        }
    }
}
