/**
 * Created by belows on 2016/11/1.
 */
public class Ex5 {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            try {
                if (i++ < 1000000) {
                    throw new Exception("exception " + i);
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("System resumption");
    }
}
