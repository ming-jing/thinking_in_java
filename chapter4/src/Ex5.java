/**
 * Created by beta on 16-9-25.
 */
public class Ex5 {
    public static void main(String[] args) {
        display(0xffffffff);
        display(1);
    }

    public static void display(int i) {
        int k = 1 << 31;
        System.out.println(Integer.toBinaryString(k));
        for (int j = 1; j <= 32; ++j) {
            int s = k & i;
            System.out.print(s != 0 ? 1 : 0);
            k >>= 1;
        }
        System.out.println();
    }
}
