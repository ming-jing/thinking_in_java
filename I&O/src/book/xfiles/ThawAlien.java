package book.xfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * Created by belows on 2016/12/26.
 */

public class ThawAlien {
    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(new File("/Users/belows/IdeaProjects/thinking_in_java/I&O/src/ex/11.txt")));
        Object mystery = in.readObject();
        System.out.println(mystery.getClass());
    }
}
