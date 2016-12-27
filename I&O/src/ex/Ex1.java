package ex;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by belows on 2016/12/16.
 */
public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String reg = "";

            if (scanner.hasNextLine()) {
                reg = scanner.nextLine();
            } else {
                break;
            }

            File file = new File(line);
            if (file.isDirectory()) {
                listAllFile(file,reg);
            }
        }
    }

    private static void listAllFile(File dir, String reg) {
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                try {
                    if (pathname.isDirectory()) {
                        return true;
                    } else if ( Ex1.accept(pathname.getAbsolutePath(), reg)) {
                        System.out.println(pathname.getAbsolutePath());
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return false;
            }
        });
        for (File file : files) {
            if (file.isDirectory()) {
                listAllFile(file,reg);
            }
        }
    }

    private static boolean accept(String fileName, String reg) throws IOException {
        File file = new File(fileName);
        if (file.isDirectory()) {
            return false;
        }
        Scanner scanner = new Scanner(new FileInputStream(file));
        Matcher matcher = Pattern.compile(reg).matcher("");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            matcher.reset(line);
            if (matcher.find()) {
                scanner.close();
                return true;
            }
        }

        return false;
    }
}
