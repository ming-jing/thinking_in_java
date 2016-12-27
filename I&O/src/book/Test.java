package book;

import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

/**
 * Created by belows on 2016/12/16.
 */
public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            while (scanner.hasNextLine()) {
                String dir = scanner.nextLine();
                File file = new File(dir);
                if (file.isDirectory()) {
                    displayFiles(file);
                }
            }
        } catch (Exception e) {}
    }

    private static void displayFiles(File file) {
        File[] files = file.listFiles(new Filter());
        System.out.println();
        System.out.println("Directory:" + file.getAbsolutePath());
        for (File f : files) {
            if (f.isDirectory()) {
                displayFiles(f);
            } else {
                System.out.print(f.getName() + ";");
            }
        }
    }

    private static class Filter implements FileFilter {
        @Override
        public boolean accept(File pathname) {
            if (pathname.isDirectory() || pathname.getName().endsWith(".java")) {
                return true;
            }
            return false;
        }
    }
}
