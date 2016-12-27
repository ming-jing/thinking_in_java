package book;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by belows on 2016/12/20.
 */

public class TestEOF {
    public static void main(String[] args)
            throws IOException {
        DataInputStream in = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("/Users/belows/IdeaProjects/thinking_in_java/I&O/src/book/TestEOF.java")));
//        while(in.available() != 0)
//            System.out.print((char)in.readByte());
        int size = in.available();
        for (int i=0 ;i<size; ++i) {
            System.out.print((char)in.readByte());
        }
    }
}
