import java.io.IOException;

/**
 * Created by belows on 2016/11/2.
 */
public class Ex22 {
    static class FailingConstructor {
        int index = 0;

        FailingConstructor(int i) throws IOException {
            if (i < 0) {
                throw new IOException();
            } else {
                index = i;
            }
        }
    }

    public static void main(String[] args) {
        try {
            new FailingConstructor(3);
        } catch (IOException e) {
        }
    }
}
