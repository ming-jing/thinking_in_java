package ex;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by belows on 2016/12/21.
 */
public class Ex12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line=br.readLine()) != null) {
            write(line,content());
        }
    }

    private static void write(String fileName, List<String> content) throws IOException {
        PrintWriter writer = new PrintWriter(fileName);

        int lineNumber = 1;
        for (String s : content) {
            writer.println(lineNumber++ + " : " + s);
        }
        writer.close();
    }

    private static List<String> content() {
        List<String> list = new LinkedList<>();
        for (int i=0; i<100; ++i) {
            list.add("Test" + i);
        }
        return list;
    }
}
