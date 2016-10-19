package ex8.tt;

/**
 * Created by beta on 16-10-1.
 */
public class ConnectionManager {
    static int index = 0;

    public static Connection getConnection() {
        if (index < 5) {
            return new Connection();
        }
        return null;
    }
}
