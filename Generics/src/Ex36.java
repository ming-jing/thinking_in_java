import java.util.List;

/**
 * Created by belows on 2016/11/15.
 */
public class Ex36 {

    interface Processor<T, E extends Exception, F extends Exception> {
        void process(List<T> list) throws E,F;
    }

    static class Failure1 extends Exception {}
    static class Failure2 extends Exception {}

    static class Processor1 implements Processor<String,Failure1,Failure1> {
        @Override
        public void process(List<String> list) throws Failure1, Failure1 {

        }
    }

    public static void main(String[] args) {
        Processor1 p = new Processor1();
    }
}
