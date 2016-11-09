/**
 * Created by belows on 2016/11/9.
 */
public class Ex26 {


    static abstract class Instrument {

        int spitValue = 0;
        void clearSpitValve() {
            spitValue = 0;
        }

        void addSpitValue() {
            spitValue++;
        }
    }

    static class Percussion extends Instrument {}

    static class Stringed extends Instrument {}

    public static void main(String[] args) {}
}
