package ex.test;

import java.io.*;

/**
 * Created by belows on 2016/12/24.
 */
public class SerTest {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        read();
//        save();
    }

    private static void save() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/Users/belows/IdeaProjects/thinking_in_java/I&O/src/ex/11.txt"));
//        out.writeObject(new SerClass(55));
        out.close();
    }

    private static void read() throws  IOException,ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("/Users/belows/IdeaProjects/thinking_in_java/I&O/src/ex/11.txt"));
//        SerClass s = (SerClass)in.readObject();
//        System.out.println(s);
//        in.close();
        in.readObject();
        in.close();
    }
}
