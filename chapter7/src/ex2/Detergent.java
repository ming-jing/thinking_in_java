package ex2;

/**
 * Created by beta on 16-10-1.
 */
class Cleaner {
    private String s = "Cleaner";

    public void append(String a) {
        s += a;
    }

    public void dilute() {
        append("dilute()");
    }

    public void apply() {
        append("apply()");
    }

    public void scrub() {
        append("scrub()");
    }

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        Cleaner x = new Cleaner();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }
}

public class Detergent {

    Cleaner cleaner = new Cleaner();

    public void append(String s) {
        cleaner.append(s);
    }

    public void dilute() {
        cleaner.dilute();
    }

    public void apply() {
        cleaner.apply();
    }

    public void scrub() {
        cleaner.append("Detergent.scrub()");
        cleaner.scrub();
    }

    public void foam() {
        cleaner.append("foam()");
    }

    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x.cleaner);
        System.out.println("Testing base class:");
        Cleaner.main(args);
    }
}
