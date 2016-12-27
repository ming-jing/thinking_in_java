package ex;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by belows on 2016/12/20.
 */
public class Ex10 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = scanner.nextLine().split("\\s+");
            StringBuilder reg = new StringBuilder();
//            reg.append("[");
            for (String word : words) {
                reg.append('(');
                reg.append(word);
                reg.append(')');
                reg.append('|');
            }
            reg.deleteCharAt(reg.length()-1);
//            reg.append("]");
            System.out.println(reg.toString());
            Matcher matcher = Pattern.compile(reg.toString()).matcher("");
            Scanner fileScanner = new Scanner(new FileInputStream(line));

            LinkedList<String> list = new LinkedList<>();
            while (fileScanner.hasNextLine()) {
                String s = fileScanner.nextLine();
                matcher.reset(s);
                if (matcher.find()) {
                    list.add(s);
                }
            }

            display(list);
        }
    }

    private static <T> void display(LinkedList<T> linkedList) {
        for (T t : linkedList) {
            System.out.println(t);
        }
    }
}
