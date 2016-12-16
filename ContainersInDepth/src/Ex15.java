import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Created by belows on 2016/12/6.
 */
public class Ex15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            while (scanner.hasNextLine()) {
                String fileName = scanner.nextLine();
                SlowMap<String,Integer> map = new SlowMap<>();
                Scanner fileScanner = new Scanner(new FileInputStream(fileName));
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] words = line.split("[^a-z&^A-Z&^0-9&^_]+");
                    for (String word : words) {
                        Integer i = map.get(word);
                        if (i == null ) {
                            map.put(word,1);
                        } else {
                            map.put(word,i+1);
                        }
                    }
                }
                System.out.println(map);
            }
        } catch (Exception e) {}
    }
}
