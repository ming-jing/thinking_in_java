package ex;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

/**
 * Created by belows on 2016/12/23.
 */
public class Ex24 {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        DoubleBuffer doubleBuffer = buffer.asDoubleBuffer();
        doubleBuffer.put(new double[] {1.0,2.0,3.3,4.4,5.5});
        doubleBuffer.flip();
        display(doubleBuffer);

        doubleBuffer.put(3,7.7);
        display(doubleBuffer);
    }

    private static void display(DoubleBuffer buffer) {
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get() + " ");
        }
        buffer.rewind();
        System.out.println();
    }
}
