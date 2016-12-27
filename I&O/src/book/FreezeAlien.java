package book;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * Created by belows on 2016/12/26.
 */
public class FreezeAlien {
    public static void main(String[] args) throws Exception {
        ObjectOutput out = new ObjectOutputStream(
                new FileOutputStream("/Users/belows/IdeaProjects/thinking_in_java/I&O/src/ex/11.txt"));
        Alien quellek = new Alien();
        out.writeObject(quellek);
    }
}
