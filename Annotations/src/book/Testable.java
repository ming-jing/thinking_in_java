package book;

/**
 * Created by belows on 2016/12/30.
 */
public class Testable {
    public void execute() {
        System.out.println("Executing..");
    }
    @Test void testExecute() { execute(); }
}
