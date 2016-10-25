import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by belows on 2016/10/25.
 */
public class Ex14 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        ListIterator<Integer> it = list.listIterator();
        Scanner scanner = new Scanner(System.in);
        int index =0;
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            it.add(i);
            if (index++%2==0) {
                it.previous();
            }
            System.out.println(list);
        }
    }
}
