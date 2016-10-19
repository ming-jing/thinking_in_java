/**
 * Created by beta on 16-10-1.
 */
class Test1 {

}

public class Ex1 {
    private Test1 test1;

    @Override
    public String toString() {
        if (test1 == null) {
            test1 = new Test1();
        }
        return test1.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Ex1());
    }
}
