package book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by belows on 2016/12/20.
 */
public class BufferedInputFile {
    public static String read(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = "";
        while ((line=br.readLine()) != null) {
            content.append(line);
            content.append('\n');
        }
        return content.toString();
    }
}
