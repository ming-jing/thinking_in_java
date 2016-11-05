import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by belows on 2016/11/5.
 */

////: strings/JGrep.java
//// A very simple version of the "grep" program.
//// {Args: JGrep.java "\\b[Ssct]\\w+"}
//import java.util.regex.*;
//import net.mindview.util.*;
//public class JGrep {
//    public static void main(String[] args) throws Exception {
//        if(args.length < 2) {
//            System.out.println("Usage: java JGrep file regex");
//            System.exit(0);
//        }
//        Pattern p = Pattern.compile(args[1]);
//        // Iterate through the lines of the input file:
//        int index = 0;
//        Matcher m = p.matcher("");
//        for(String line : new TextFile(args[0])) {
//            m.reset(line);
//            while(m.find())
//                System.out.println(index++ + ": " +
//                        m.group() + ": " + m.start());
//        } }
//}
public class Ex15 {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/belows/IdeaProjects/thinking_in_java/Strings/src/Ex15.java");
        FileInputStream inputStream = new FileInputStream(file);
        StringBuilder builder = new StringBuilder();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);

        while (len != -1) {
            String s = new String(bytes,0,len);
            builder.append(s);
            len = inputStream.read(bytes);
        }

        String reg = "(?m)^//.*$";
        Matcher m = Pattern.compile(reg).matcher(builder.toString());
        builder = new StringBuilder();
        while (m.find()) {
            builder.append(m.group());
            builder.append("\n");
        }

        StringBuffer buffer = new StringBuffer();
        reg = "(?m)^//";
        m = Pattern.compile(reg).matcher(builder.toString());
        while (m.find()) {
            m.appendReplacement(buffer,"");
        }
        m.appendTail(buffer);

        String s = buffer.toString();
        Scanner scanner = new Scanner(System.in);
        String[] sa = s.split("\n");

        while (scanner.hasNext()) {
            reg = scanner.nextLine();
            m = Pattern.compile(reg,Pattern.CASE_INSENSITIVE).matcher("");
            int index = 0;
            m.reset(s);
                while (m.find()) {
                    System.out.println(index++ + ":" + m.group() + ": " + m.start());
                }
        }
    }
}
