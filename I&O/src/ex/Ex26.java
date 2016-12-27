package ex;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Created by belows on 2016/12/23.
 */
public class Ex26 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
//        Charset.availableCharsets();
//        for (String s : Charset.availableCharsets().keySet()) {
//            System.out.println(s);
//        }
        while (scanner.hasNextLine()) {
            String fileName = scanner.nextLine();
            long start = System.nanoTime();
            File file = new File(fileName);
            MappedByteBuffer mappedByteBuffer = new RandomAccessFile(fileName,"rw").getChannel().map(FileChannel.MapMode.READ_WRITE,0,file.length());
//            Charset.forName("UTF-8").decode(mappedByteBuffer);
            mappedByteBuffer.rewind();
//            CharBuffer buffer = Charset.forName("UTF-8").decode(mappedByteBuffer);
            while (mappedByteBuffer.hasRemaining()) {
                mappedByteBuffer.get();
            }
            System.out.println(System.nanoTime() - start);
            start = System.nanoTime();
            FileChannel channel = new FileInputStream(fileName).getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate((int)channel.size());
            channel.read(byteBuffer);
            byteBuffer.flip();
//            buffer = Charset.forName("UTF-8").decode(byteBuffer);
            while (byteBuffer.hasRemaining()) {
                byteBuffer.get();
            }
            System.out.println(System.nanoTime() - start);
            System.out.println("\n\n");
        }
    }
}

//    String encoding = System.getProperty("file.encoding");
//        System.out.println("Decoded using " + encoding + ": "
//                + Charset.forName(encoding).decode(buff));