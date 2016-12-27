package book;

import java.io.*;

/**
 * Created by belows on 2016/12/20.
 */
public class BasicFileOutput {
    static String file = "BasicFileOutput.out";
    public static void main(String[] args)
            throws IOException {
        BufferedReader in = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("/Users/belows/IdeaProjects/thinking_in_java/I&O/src/book/BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(
                new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while((s = in.readLine()) != null ) {
            out.println(lineCount++ + ": " + s);
//            out.println();
        }
        out.close();
        // Show the stored file:
        System.out.println(BufferedInputFile.read(file));
    }
}
