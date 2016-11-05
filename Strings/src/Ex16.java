import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by belows on 2016/11/5.
 */
public class Ex16 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String file = scanner.nextLine();
        Path path = Paths.get(file);
        String input = null;
        if (Files.isDirectory(path,LinkOption.NOFOLLOW_LINKS)) {
            input = readDir(file);
        } else {
            input = readFile(file);
        }

        while (scanner.hasNext()) {

            String reg = scanner.nextLine();
            Matcher m = Pattern.compile(reg,Pattern.MULTILINE).matcher(input);
            int index = 0;
            while (m.find()) {
                System.out.println(index++ + ": " + m.group() + ": " + m.start());
            }
        }
    }

    public static String readDir(String dirName) throws IOException {
        File dir = new File(dirName);
        StringBuilder builder = new StringBuilder();

        if (!dir.isDirectory()) {
            throw new IllegalStateException("not a directory");
        } else {
            File[] files = dir.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    builder.append(readDir(file.getAbsolutePath()));
                } else {
                    builder.append(readFile(file.getAbsolutePath()));
                }
            }
        }

        return builder.toString();
    }

    public static String readFile(String fileName) throws IOException {
        FileInputStream inputStream = new FileInputStream(fileName);
        byte[] bytes = new byte[256];
        int len = inputStream.read(bytes);
        StringBuilder builder = new StringBuilder();

        while (len != -1) {
            builder.append(new String(bytes,0,len));
            len = inputStream.read(bytes);
        }
        return builder.toString();
    }
}
