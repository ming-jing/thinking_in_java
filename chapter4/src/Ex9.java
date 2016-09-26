/**
 * Created by beta on 16-9-26.
 */
public class Ex9 {
    public static void main(String[] args) {
        fib(5);
    }

    public static void fib(int f) {
        int i1 = 1;
        int i2 = 1;

        System.out.print(1 + " " + 1);
        if (f <= 2) {
            return;
        }
        for (int i = 2; i < f; ++i) {
            int i3 = i1 + i2;
            System.out.print(" " + i3);
            i1 = i2;
            i2 = i3;
        }
    }
}
