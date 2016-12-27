package ex;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by belows on 2016/12/19.
 */
public class Ex4 {
    private static class Directory {

        private int matchCount = 0;

        public void walk(File file, Matcher matcher) {

            File[] files = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    if (matcher.reset(pathname.getAbsolutePath()).matches()) {
                        ++matchCount;
                    }
                    if (pathname.isDirectory()) {
                        return true;
                    }
                    return false;
                }
            });
            for (File f : files) {
                walk(f,matcher);
            }
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Directory dir = new Directory();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                File file = new File(line);
                String reg = scanner.nextLine();
                Matcher matcher = Pattern.compile(reg).matcher("");
                dir.walk(file,matcher);
                System.out.println(dir.matchCount);
                dir.matchCount = 0;
            }
        }
    }
}
