/**
 * Created by beta on 16-9-25.
 */
public class Ex13 {
    public static void main(String[] args) {
        display('A');
        display('c');
        display('F');
    }

    public static void display(char c) {
        System.out.println(Integer.toBinaryString(c));
    }
}
