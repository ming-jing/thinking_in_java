import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by belows on 2016/11/1.
 */

class Exception61 extends Exception {
    Logger logger = Logger.getLogger("Ex61 logger");

    private void print(String msg) {
        logger.log(Level.WARNING,msg);
    }

    public Exception61() {
        super();
        print("default constructor");
    }

    public Exception61(String message) {
        super(message);
        print(message);
    }
}

class Exception62 extends Exception {
    Logger logger = Logger.getLogger("Ex62 logger");

    private void print(String msg) {
        logger.severe(msg);
    }

    public Exception62() {
        super();
        print("default constructor");
    }

    public Exception62(String message) {
        super(message);
        print(message);
    }
}

public class Ex6 {
    public static void main(String[] args) {
        try {
            throw new Exception61();
        } catch (Exception61 e) {}
        try {
            throw new Exception61("Test 61");
        } catch (Exception61 e) {}
        try {
            throw new Exception62();
        } catch (Exception62 e) {}
        try {
            throw new Exception62("Test 62");
        } catch (Exception62 e) {}
    }
}
