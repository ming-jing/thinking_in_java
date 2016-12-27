package ex;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by belows on 2016/12/16.
 */
public class Ex2 {
    private static class SortedDirList {

        File file = null;

        public SortedDirList(File file) {
            this.file = file;
        }

        public String[] list() {
            String[] files = file.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    File file = new File(name);
                    if (file.isDirectory()) {
                        return true;
                    }
                    return false;
                }
            });

             Arrays.sort(files,String.CASE_INSENSITIVE_ORDER);
            return files;
        }

        public String[] list(String reg) {
            Matcher matcher = Pattern.compile(reg).matcher("");
            String[] files = file.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    File file = new File(name);
                    matcher.reset(name);
                    if (file.isDirectory() && matcher.find()) {
                        return true;
                    }
                    return false;
                }
            });
            Arrays.sort(files,String.CASE_INSENSITIVE_ORDER);
            return files;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String reg = "";
            if (scanner.hasNextLine()) {
                reg = scanner.nextLine();
            }
            SortedDirList sortedDirList = new SortedDirList(new File(line));
            System.out.println("all:" + Arrays.toString(sortedDirList.list()));
            System.out.println("filter:" + Arrays.toString(sortedDirList.list(reg)));
        }
    }
}
