package book;

import java.io.*;

/**
 * Created by belows on 2016/12/20.刘奎的
 */
public class MemoryInput {
    public static void main(String[] args)
            throws IOException {
        StringReader in = new StringReader(
                BufferedInputFile.read("/Users/belows/IdeaProjects/thinking_in_java/I&O/src/book/MemoryInput.java"));
        int c;
        while((c = in.read()) != -1)
            System.out.print((char)c);
    }

    private static class BufferedInputFile {
        public static String read(String fileName) throws IOException {
            StringBuilder content = new StringBuilder();

            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line=br.readLine()) != null) {
                content.append(line);
                content.append('\n');
            }
            return content.toString();
        }
    }
}
