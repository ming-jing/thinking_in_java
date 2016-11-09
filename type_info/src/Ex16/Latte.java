//: generics/coffee/Latte.java
package Ex16;

public class Latte extends Coffee {
    public static Factory<Latte> factory = new Factory<Latte>() {
        @Override
        public Latte create() {
            return new Latte();
        }
    };
} ///:~
