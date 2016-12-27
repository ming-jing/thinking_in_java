package book;

import java.io.PrintWriter;

/**
 * Created by belows on 2016/12/22.
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out,true);
        out.println("Hello, world");
    }
}
