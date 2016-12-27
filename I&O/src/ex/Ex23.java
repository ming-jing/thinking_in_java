package ex;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * Created by belows on 2016/12/23.
 */
public class Ex23 {

    private static void display(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get());
        }
    }

    public static void main(String[] args) throws IOException {
        ByteBuffer buffer = ByteBuffer.wrap("I love China".getBytes("UTF-16BE"));
        display(buffer.asCharBuffer());
    }
}
