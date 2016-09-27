/**
 * Created by beta on 16-9-27.
 */
public class Ex3 {
    Ex3() {
        System.out.println("Default Constructor");
    }

    Ex3(String s) {
        System.out.println("Init with " + s);
    }

    public static void main(String[] args) {
        new Ex3();
        new Ex3("test");
    }
}
