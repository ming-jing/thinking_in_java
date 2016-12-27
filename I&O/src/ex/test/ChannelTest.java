package ex.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

/**
 * Created by belows on 2016/12/23.
 */
public class ChannelTest {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    test1();
                    break;
                case 2:
                    test2();
                    break;
                case 3:
                    test3();
                    break;
            }
        }
    }

    public static void test1() throws IOException {
        Scanner scanner = new Scanner(System.in);

        String fileName = scanner.nextLine();
        FileChannel fc = new FileOutputStream(fileName).getChannel();
        fc.write(ByteBuffer.wrap("I love".getBytes()));
        fc.close();

        fc = new RandomAccessFile(fileName,"rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap(" China".getBytes()));
        fc.close();

        fc = new FileInputStream(fileName).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate((int)fc.size());
        fc.read(buffer);
        buffer.flip();
        while (buffer.hasRemaining()) {
            System.out.print((char)buffer.get());
        }
        System.out.println();
        fc.close();
    }

    public static void test2() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String inFile = scanner.nextLine();
        String outFile = scanner.nextLine();

        FileChannel inChannel = new FileInputStream(inFile).getChannel();
        FileChannel outChannel = new FileOutputStream(outFile).getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (inChannel.read(buffer) != -1) {
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }
        inChannel.close();
        outChannel.close();
    }

    public static void test3() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String inFile = scanner.nextLine();
        String outFile = scanner.nextLine();

        FileChannel inChannel = new FileInputStream(inFile).getChannel();
        FileChannel outChannel = new FileOutputStream(outFile).getChannel();
//        inChannel.transferTo(0,inChannel.size(),outChannel);
        outChannel.transferFrom(inChannel,0,inChannel.size());
    }
}
