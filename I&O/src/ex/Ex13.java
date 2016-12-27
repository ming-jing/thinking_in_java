package ex;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by belows on 2016/12/21.
 */
public class Ex13 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            display(read(line));
//            display(lineNumberRead(line));
        }
    }

    private static List<String> read(String fileName) throws IOException {
        List<String> list = new ArrayList<>();

        FileInputStream in = new FileInputStream(fileName);
        int size = 10;
        byte[] buffer = new byte[size];
        int offset = 0;

        while (in.available() > 0) {

            int len = in.available()>size?size:in.available();
            System.out.println(len);
            in.read(buffer,0,len);

            String s = new String(buffer,0,len);
            list.add(s);
            offset += s.length();
        }
        return list;
    }

    private static List<String> lineNumberRead(String fileName) throws IOException {
        List<String> list = new ArrayList<>();

        LineNumberReader reader = new LineNumberReader(new FileReader(fileName));
        String line = null;
        while ((line = reader.readLine()) != null) {
            list.add(reader.getLineNumber() +  " : " + line);
        }
        return list;
    }

    private static void display(List<String> list) {
        for (String s : list) {
            System.out.print(s);
        }
    }
}
