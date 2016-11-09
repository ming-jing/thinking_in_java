//: generics/coffee/Breve.java
package Ex16;

public class Breve extends Coffee {
    public static Factory<Breve> factory = new Factory<Breve>() {
        @Override
        public Breve create() {
            return new Breve();
        }
    };
} ///:~
