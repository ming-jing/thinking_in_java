package ex;

import java.io.File;
import java.io.FileFilter;
import java.io.FilterInputStream;
import java.nio.file.Files;
import java.util.*;

/**
 * Created by belows on 2016/12/19.
 */
public class Ex6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            File file = new File(line);
            String time = scanner.nextLine();
            String[] items = time.split("-");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR,Integer.parseInt(items[0]));
            calendar.set(Calendar.MONTH, Integer.parseInt(items[1]));
            calendar.set(Calendar.DAY_OF_MONTH,Integer.parseInt(items[2]));
            System.out.println(find(file,calendar.getTime()));
        }
    }

    private static List<File> find(File dir, Date date) {
        List<File> fileList = new ArrayList<>();
        final long time = date.getTime();
        File[] files = dir.listFiles();
        for (File file :files) {
            if (file.lastModified() > time) {
                fileList.add(file);
            }
            if (file.isDirectory()) {
                fileList.addAll(find(file,date));
            }
        }
        return fileList;
    }
}
