package book;

/**
 * Created by belows on 2016/12/27.
 */
enum Search { HITHER, YON }
public class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITHER; // Upcast
        // e.values(); // No values() in Enum
        for(Enum en : e.getClass().getEnumConstants())
            System.out.println(en);
        for (Enum en : Search.class.getEnumConstants()) {
            System.out.println(en);
        }
    }
}
