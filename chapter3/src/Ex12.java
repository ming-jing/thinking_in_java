/**
 * Created by beta on 16-9-25.
 */
public class Ex12 {
    public static void main(String[] args) {
        int l = 0xffffffff;
        display(l);
        l <<= 1;
        display(l);
        l >>>= 1;
        display(l);
    }

    private static void display(int i) {
        System.out.println(Integer.toBinaryString(i));
    }
}
