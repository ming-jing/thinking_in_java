import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by belows on 2016/10/25.
 */
public class Ex15 {

    static class Stack<T> {
        private LinkedList<T> ts = new LinkedList<T>();

        public void push(T t) {
            ts.addFirst(t);
        }

        public T pop() {
            T t = ts.removeFirst();
            return t;
        }

        public boolean isEmpty() {
            return ts.isEmpty();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line);
            char[] cs = line.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int i=0; i<cs.length;++i) {
                char c = cs[i];
                if (c == '+') {
                    stack.push(cs[++i]);
                } else if (c == '-') {
                    System.out.print(stack.pop());
                }
            }
        }

    }
}
