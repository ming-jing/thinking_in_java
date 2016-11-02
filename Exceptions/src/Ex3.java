/**
 * Created by belows on 2016/11/1.
 */
public class Ex3 {
    public static void main(String[] args) {
        int a[] = new int[10];
        try {
            for (int i = 0; i <= 10; ++i) {
                a[i] = i + 1;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("array index out of bounds caught");
            e.printStackTrace();
        }
    }
}
