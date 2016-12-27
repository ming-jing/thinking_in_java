package ex;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Created by belows on 2016/12/20.
 */
public class Ex9 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String fileName = scanner.nextLine();
            LinkedList<String> list = new LinkedList<>();
            Scanner fileScanner = new Scanner(new FileInputStream(fileName));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                list.add(line.toUpperCase());
            }
            display(list);
        }
    }

    private static <T> void display(LinkedList<T> list) {
        ListIterator<T> it = list.listIterator(list.size());
        while (it.hasPrevious()) {
            T t = it.previous();
            System.out.println(t.toString());
        }
        System.out.println();
    }
}
