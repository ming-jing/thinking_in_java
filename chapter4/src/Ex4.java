/**
 * Created by beta on 16-9-25.
 */
public class Ex4 {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; ++i) {
            if (isSushu(i)) {
                System.out.print(i + "  ");
            }
        }
    }

    public static boolean isSushu(int i) {
        for (int j = 2, s = i / 2; j <= s; ++j) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
