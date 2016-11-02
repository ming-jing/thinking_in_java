/**
 * Created by belows on 2016/11/2.
 */
public class Ex27 {
    public static void main(String[] args) {
        int a[] = new int[10];
        try {
            for (int i = 0; i <= 10; ++i) {
                a[i] = i + 1;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }
}
