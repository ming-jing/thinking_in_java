/**
 * Created by beta on 16-9-25.
 */
public class Ex7 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; ++i) {
            System.out.println(i);
            if (i == 99) {
                return;
            }
        }
    }
}
