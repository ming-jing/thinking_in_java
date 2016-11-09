//: generics/coffee/Mocha.java
package Ex16;

public class Mocha extends Coffee {
    public static Factory<Mocha> factory = new Factory<Mocha>() {
        @Override
        public Mocha create() {
            return new Mocha();
        }
    };
} ///:~
