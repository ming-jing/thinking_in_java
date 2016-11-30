import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by belows on 2016/11/28.
 */
public class Ex4 {

    private static void fill(Collection<String> coll, String fileName) throws IOException {
//        FileInputStream inputStream = new FileInputStream(fileName);
//        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        while (scanner.hasNext()) {
            coll.add(scanner.next());
        }
        System.out.println(coll);
    }

    public static void main(String[] args) throws IOException {
        List<String> arrayList = new ArrayList<>();
        fill(arrayList,"/Users/belows/IdeaProjects/thinking_in_java/ContainersInDepth/src/Ex4.java");

        List<String> linkedList = new ArrayList<>();
        fill(linkedList,"/Users/belows/IdeaProjects/thinking_in_java/ContainersInDepth/src/Ex4.java");
    }
}
