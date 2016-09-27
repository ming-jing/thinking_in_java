/**
 * Created by beta on 16-9-27.
 */
class Dog {
    public void bark() {
        System.out.print("bark nothing");
    }

    public void bark(byte b) {
        System.out.println("bark byte:" + b);
    }

    public void bark(char c) {
        System.out.println("bark char: " + c);
    }

    public void bark(short s) {
        System.out.println("bark short:" + s);
    }

    public void bark(int i) {
        System.out.println("bark int:" + i);
    }

    public void bark(boolean b) {
        System.out.println("bark boolean: " + b);
    }

    public void bark(long l) {
        System.out.println("bark long: " + l);
    }

    public void bark(float f) {
        System.out.println("bark float:" + f);
    }

    public void bark(double d) {
        System.out.println("bark double:" + d);
    }
}

public class Ex5 {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.bark();
        d.bark(false);
        d.bark((byte) 1);
        d.bark('c');
        d.bark((short) 3);
        d.bark(3);
        d.bark(3L);
        d.bark(3f);
        d.bark(3D);
    }
}
