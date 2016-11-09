//: generics/coffee/Americano.java
package Ex16;

public class Americano extends Coffee {
    public static Factory<Americano> factory = new Factory<Americano>() {
        @Override
        public Americano create() {
            return new Americano();
        }
    };
} ///:~
