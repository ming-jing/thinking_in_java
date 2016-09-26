/**
 * Created by beta on 16-9-25.
 */
public class Ex6 {
    public static void main(String[] args) {
        System.out.println(test(10, 3, 7));
        System.out.println(test(3, 1, 6));
    }

    public static int test(int testval, int begin, int end) {
        if (testval < end && testval > begin) {
            return 1;
        }
        return 0;
    }
}
