/**
 * Created by beta on 16-9-28.
 */
public class Ex10 {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("ex10 finalize");
    }

    public static void main(String[] args) {
        while (true) {
            new Ex10();
        }
    }
}
