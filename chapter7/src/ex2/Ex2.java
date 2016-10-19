package ex2;

/**
 * Created by beta on 16-10-1.
 */
public class Ex2 extends Detergent {
    @Override
    public void scrub() {
        append("Ex2 scrub");
        super.scrub();
    }

    public void sterilize() {
        append("Ex2 sterilize()");
    }

    public static void main(String[] args) {
        Ex2 ex2 = new Ex2();
        ex2.dilute();
        ex2.apply();
        ex2.scrub();
        ex2.foam();
        ex2.sterilize();
        System.out.println(ex2);
    }
}
