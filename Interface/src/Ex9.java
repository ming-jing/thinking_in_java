import java.util.Random;

/**
 * Created by belows on 2016/10/19.
 */

abstract class Instrument {
    abstract void play();
}

class Wind extends Instrument {
    @Override
    void play() {
        System.out.println("Wind Play");
    }
}

class Percussion extends Instrument {
    @Override
    void play() {
        System.out.println("Percussion Play");
    }
}

class Stringed extends Instrument {
    @Override
    void play() {
        System.out.println("Stringed Play");
    }
}

public class Ex9 {

    public static Random random = new Random();
    public static Instrument next() {
            int index = random.nextInt(3);
        switch (index) {
            default:
            case 0:
                return new Wind();
            case 1:
                return new Percussion();
            case 2:
                return new Stringed();
        }
    }

    public static void main(String[] args) {
        Instrument[] instrument = new Instrument[10];
        for (int i=0; i<instrument.length;++i) {
            instrument[i] = next();
        }
        for (Instrument instrument1 : instrument) {
            instrument1.play();
        }
    }
}
