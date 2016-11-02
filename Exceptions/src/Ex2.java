/**
 * Created by belows on 2016/11/1.
 */
public class Ex2 {
    public static void main(String[] args) {
        String s = null;
        try {
            s.contains("ccc");
        } catch (NullPointerException e) {
            System.out.println("null pointer");
        }
    }
}
