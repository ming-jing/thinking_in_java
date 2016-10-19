import java.util.Random;

/**
 * Created by belows on 16/10/16.
 */

enum Note {
    MIDDLE_C
}
class Instrument {
    void play(Note n) { System.out.println("Instrument.play() " + n); }
    void adjust() { System.out.println("Adjusting Instrument"); }
}
class Wind extends Instrument {
    void play(Note n) { System.out.println("Wind.play() " + n); }
    public String toString() { return "Wind"; }
    void adjust() { System.out.println("Adjusting Wind"); }
}
class Percussion extends Instrument {
    void play(Note n) { System.out.println("Percussion.play() " + n); }
    public String toString() { return "Percussion"; }
    void adjust() { System.out.println("Adjusting Percussion"); }
}
class Stringed extends Instrument {
    void play(Note n) { System.out.println("Stringed.play() " + n); }
    public String toString() { return "Stringed"; }
    void adjust() { System.out.println("Adjusting Stringed"); }
}
class Brass extends Wind {
    void play(Note n) { System.out.println("Brass.play() " + n); }
    void adjust() { System.out.println("Adjusting Brass"); }
}
class Woodwind extends Wind {
    void play(Note n) { System.out.println("Woodwind.play() " + n); }
    public String toString() { return "Woodwind"; }
}

class NewType extends Instrument {
    @Override
    void play(Note n) {
        System.out.println("NewType.play()" + n);
    }

    @Override
    void adjust() {
        System.out.println("NewType");
    }

//    @Override
//    public String toString() {
//        return "NewType";
//    }
}

public class Ex6 {
    // Doesn’t care about type, so new types
    // added to the system still work right:
    public static void tune(Instrument i) {
// ...
        i.play(Note.MIDDLE_C);
    }
    public static void tuneAll(Instrument[] e) {
        for(Instrument i : e) {
            tune(i);
            System.out.println(i);
        }
    }

    static Random random = new Random();
    public static Instrument next() {
        int index = random.nextInt(6);
        switch (index) {
            default:
            case 0:
                return new Wind();
            case 1:
                return new Percussion();
            case 2:
                return new Stringed();
            case 3:
                return new Brass();
            case 4:
                return new Woodwind();
            case 5:
                return new NewType();
        }
    }

    public static void main(String[] args) {
        // Upcasting during addition to the array:
//        Instrument[] orchestra = {
//                new Wind(),
//                new Percussion(),
//                new Stringed(),
//                new Brass(),
//                new Woodwind(),
//                new NewType()
//        };
//        tuneAll(orchestra);
        Instrument[] arrays = new Instrument[10];
        for (int i=0; i<arrays.length; ++i) {
            arrays[i] = next();
        }
        tuneAll(arrays);
    }
}
