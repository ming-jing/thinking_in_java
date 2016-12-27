package ex;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by belows on 2016/12/21.
 */
public class Ex16 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randFile = new RandomAccessFile("kk.txt","rw");
        randFile.writeUTF("test");
        randFile.writeInt(333);
        randFile.writeDouble(3333.333);
        randFile.close();

        randFile = new RandomAccessFile("kk.txt","r");
        System.out.println(randFile.readUTF());
        System.out.println(randFile.readInt());
        System.out.println(randFile.readDouble());
    }
}
