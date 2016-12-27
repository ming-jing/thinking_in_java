package ex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by belows on 2016/12/21.
 */
public class Ex17 {

    private static class TextFile extends ArrayList<String> {

        private static final int BUFFER_SIZE = 128;

        public static String read(String fileName) throws IOException {
            StringBuilder builder = new StringBuilder();

            FileInputStream inputStream = new FileInputStream(fileName);
            byte[] buffer = new byte[BUFFER_SIZE];
            while (inputStream.available() != 0) {
                int len = inputStream.available()>BUFFER_SIZE?BUFFER_SIZE:inputStream.available();
                inputStream.read(buffer,0,len);
                builder.append(new String(buffer,0,len));
            }
            return builder.toString();
        }

        public static void write(String fileName,String content) throws IOException {
            PrintWriter writer = new PrintWriter(fileName);
            writer.write(content);
            writer.close();
        }

        public TextFile(String fileName) {
            try {
                addAll(Arrays.asList(read(fileName).split("\n+")));
            } catch (IOException e) {}
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (String s : this) {
                builder.append(s);
                builder.append("\n");
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Map<Character,Integer> map = new TreeMap<>();
        while (scanner.hasNextLine()) {
            String fileName = scanner.nextLine();
            String content = TextFile.read(fileName);
            char[] chars = content.toCharArray();
            for (char c : chars) {
                if (!Character.isAlphabetic(c)) {
                    continue;
                }
                Integer i = map.get(c);
                if (i == null) {
                    map.put(c,1);
                } else {
                    map.put(c,i+1);
                }
            }
            System.out.println(map);
        }
    }
}
