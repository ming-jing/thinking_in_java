package ex;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by belows on 2016/12/16.
 */
public class Ex3 {
    private static class DirList {
        int count = 0;

        public int list(String fileName,String reg) {
            count = 0;
            File file = new File(fileName);
            Matcher matcher = Pattern.compile(reg).matcher("");

            String[] files = file.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    if (matcher.reset(name).matches()) {
                        count ++;
                        return true;
                    }
                    return false;
                }
            });
            System.out.println(files.length);
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirList dirList = new DirList();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String reg = "";
            if (scanner.hasNextLine()) {
                reg = scanner.nextLine();
            }
            int count = dirList.list(line,reg);
            System.out.println(count);
        }

    }
}
