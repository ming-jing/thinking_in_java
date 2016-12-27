package ex;

import nu.xom.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by belows on 2016/12/26.
 */
public class Ex32 {
    public static void main(String[] args) throws IOException,ParsingException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            FileChannel fc  = new FileInputStream(line).getChannel();
            MappedByteBuffer buffer = fc.map(FileChannel.MapMode.READ_ONLY,0,fc.size());

            Map<String,Integer> map = new HashMap<>();
            while ((line = nextLine(buffer)) != null) {
                String[] array = line.split("\\W+");
                for (String ks : array) {
                    Integer i = map.get(ks);
                    if (i == null ) {
                        map.put(ks,0);
                    } else {
                        map.put(ks,i+1);
                    }
                }
            }

            save(map,Ex31.file);
        }
    }

    public static String nextLine(MappedByteBuffer buffer) {
        if (!buffer.hasRemaining()) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        while (buffer.hasRemaining()) {
            char c = (char)buffer.get();
            if (c != '\n') {
                builder.append(c);
            } else {
                break;
            }
        }
        if (builder.length() == 0) {
            return nextLine(buffer);
        }
        return builder.toString();
    }

    public static void save(Map<String,Integer> map,String fileName) throws IOException, ParsingException {
        Element root = new Element("Text-Words");
        Document doc = new Document(root);
        for (Map.Entry<String,Integer> entry:map.entrySet()) {
            Element item = new Element("word");
            Element text = new Element("text");
            Element count = new Element("count");
            text.appendChild(entry.getKey());
            count.appendChild(entry.getValue().toString());
            item.appendChild(text);
            item.appendChild(count);

            root.appendChild(item);
        }
        FileOutputStream outputStream = new FileOutputStream(fileName);
        Serializer serializer = new Serializer(outputStream,"UTF-8");
        serializer.setIndent(4);
        serializer.setMaxLength(1024);
        serializer.write(doc);
        serializer.flush();
        outputStream.close();
    }
}
