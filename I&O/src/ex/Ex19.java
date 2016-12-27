package ex;

import book.BinaryFile;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by belows on 2016/12/22.
 */
public class Ex19 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Map<Byte,Integer> map = new TreeMap<>();

        while (scanner.hasNextLine()) {
            map.clear();
            String line = scanner.nextLine();
            byte[] bytes = BinaryFile.read(line);
            for (byte b : bytes) {
                Integer i = map.get(b);
                if (i == null) {
                    map.put(b,1);
                } else {
                    map.put(b,i+1);
                }
            }

            System.out.println(map);
        }
    }
}
