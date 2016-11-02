/**
 * Created by belows on 2016/11/1.
 */

class Switch {
    private boolean state = false;
    public boolean read() { return state; }
    public void on() { state = true; System.out.println(this); }
    public void off() { state = false; System.out.println(this); }
    public String toString() { return state ? "on" : "off"; }
}

class OnOffException1 extends Exception {}

class OnOffException2 extends Exception {}

class OnOffSwitch {
    private static Switch sw = new Switch();
    public static void f()
            throws OnOffException1,OnOffException2 {
        throw new NullPointerException();
    }
    public static void main(String[] args) {
        try {
            sw.on();
            // Code that can throw exceptions...
            f();
            sw.off();
        } catch(OnOffException1 e) {
            System.out.println("OnOffException1");
            sw.off();
        } catch(OnOffException2 e) {
            System.out.println("OnOffException2");
            sw.off(); }
    }
}

class WithFinally {
    static Switch sw = new Switch();
    public static void main(String[] args) {
        try {
            sw.on();
            // Code that can throw exceptions...
            OnOffSwitch.f();
        } catch(OnOffException1 e) {
            System.out.println("OnOffException1");
        } catch(OnOffException2 e) {
            System.out.println("OnOffException2");
        } finally {
            sw.off(); }
    }
}

public class Ex14 {

    public static void main(String[] args) {
//        OnOffSwitch.main(args);
        WithFinally.main(args);
    }
}
