package book;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.Scanner;

/**
 * Created by belows on 2016/12/23.
 */
public class TransferTo {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        args =  scanner.nextLine().split("\\s+");

        FileChannel
                in = new FileInputStream(args[0]).getChannel(),
                out = new FileOutputStream(args[1]).getChannel();
        in.transferTo(0, in.size(), out);
        // Or:
        // out.transferFrom(in, 0, in.size());
    }
}
