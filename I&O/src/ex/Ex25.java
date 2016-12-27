package ex;

import java.nio.ByteBuffer;

/**
 * Created by belows on 2016/12/23.
 */
public class Ex25 {
    public static final int size = 1000000000;
    public static void main(String[] args) {
        long start = System.nanoTime();
        ByteBuffer.allocate(size);
        System.out.println((System.nanoTime() - start)/10e9);

        start = System.nanoTime();
        ByteBuffer.allocateDirect(size);
        System.out.println((System.nanoTime() - start)/10e9);
    }
}
