package ex;

import java.io.*;

/**
 * Created by belows on 2016/12/21.
 */
public class Ex15 {
    public static void main(String[] args) throws IOException {
        DataOutputStream writer = new DataOutputStream(new FileOutputStream("11.txt"));
        writer.writeBytes("sssss");
        writer.writeUTF("test");
        writer.close();

        DataInputStream reader = new DataInputStream(new FileInputStream("11.txt"));
        System.out.println(reader.readByte());
        System.out.println(reader.readByte());
        System.out.println(reader.readByte());
        System.out.println(reader.readByte());
        System.out.println(reader.readByte());
//        System.out.println(reader.readByte());
//        System.out.println(reader.readByte());
//        System.out.println(reader.readByte());
//        System.out.println(reader.readByte());
//        System.out.println(reader.readByte());
//        System.out.println(reader.readUTF());
        System.out.println(reader.readUTF());
    }
}
