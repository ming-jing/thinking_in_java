package ex;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by belows on 2016/12/22.
 */
public class Ex22 {

    public static List<String> command(String command) throws IOException {
        List<String> list = new ArrayList<>();
        List<String> errors = new ArrayList<>();

        Process process = new ProcessBuilder(command.split("\\s+")).start();
        Scanner in = new Scanner(process.getInputStream());
        while (in.hasNextLine()) {
            list.add(in.nextLine());
        }

        ByteBuffer byteBuffer = ByteBuffer.allocate(32);
        Scanner error = new Scanner(process.getErrorStream());
        while (error.hasNextLine()) {
            errors.add(error.nextLine());
        }
        System.out.println(errors);
        return list;
    }


    public static void main(String[] args) throws  IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();
            System.out.println(command(command));
        }
    }
}
