import java.io.IOException;

/**
 * Created by belows on 2016/11/2.
 */
public class Ex23 {
    static class T {
        T() {
            System.out.println("T created");
        }
        void dispose() {
            System.out.println("T dispose");
        }
    }

    static class FailingConstructor {
        int index = 0;
        T t1;
        T t2;
        FailingConstructor(int i) throws IOException{

            t1 = new T();

            if (i < 0) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    t1.dispose();
                    throw e;
                }
            } else {
                index = i;
            }

            t2 = new T();
        }

        public void dispose() {
            if (t1 != null) {
                t1.dispose();
            }
            if (t2 != null) {
                t2.dispose();
            }
        }
    }

    public static void main(String[] args) {
        FailingConstructor f = null;
        try {
            f = new FailingConstructor(-1);
        } catch (IOException e) {

        } finally {
            if (f != null) {
                f.dispose();
            }
        }
    }
}
