//: generics/coffee/Cappuccino.java
package Ex16;

public class Cappuccino extends Coffee {
    public static Factory<Cappuccino> factory = new Factory<Cappuccino>() {
        @Override
        public Cappuccino create() {
            return new Cappuccino();
        }
    };
} ///:~
