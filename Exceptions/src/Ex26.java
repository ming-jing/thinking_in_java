import java.io.FileInputStream;

/**
 * Created by belows on 2016/11/2.
 */
public class Ex26 {
    static class MainException {
        // Pass all exceptions to the console:
        public static void main(String[] args) throws Exception {
            // Open the file:
            FileInputStream file =
                    new FileInputStream("MainException.java");
            // Use the file ...
            // Close the file:
            file.close();
        }
    }

    public static void main(String[] args) throws Exception {
        MainException.main(args);
    }
}
