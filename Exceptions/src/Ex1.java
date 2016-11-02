/**
 * Created by belows on 2016/11/1.
 */
public class Ex1 {
    public static void main(String[] args) {
        try {
            throw new Exception("exception test");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally called");
        }
    }
}
