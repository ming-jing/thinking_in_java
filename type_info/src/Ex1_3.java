import java.util.Arrays;
import java.util.List;

/**
 * Created by beta on 16-8-31.
 */
abstract class Shape {
    boolean highLight = false;

    void draw() {
        System.out.println(this + ".draw()");
    }

    abstract public String toString();

    abstract public void rotate();
}

class CirCle extends Shape {
    @Override
    public String toString() {
        return "Circle highLight" + highLight;
    }

    @Override
    public void rotate() {
        System.out.println("Circle rotate");
    }
}

class Square extends Shape {
    @Override
    public String toString() {
        return "Square highLight " + highLight;
    }

    @Override
    public void rotate() {
        System.out.println("Square rotate");
    }
}

class Triangle extends Shape {
    @Override
    public String toString() {
        return "Triangle highLight " + highLight;
    }

    @Override
    public void rotate() {
        System.out.println("Triangle rotate");
    }
}

class Rhomboid extends Shape {
    @Override
    public String toString() {
        return "Rhomboid highLight " + highLight;
    }

    @Override
    public void rotate() {
        System.out.println("Rhomboid rotate");
    }
}

public class Ex1_3 {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(new CirCle(), new Square(), new Triangle(), new Rhomboid());

        System.out.println(shapes);
        Shape s = new Rhomboid();
        if (Rhomboid.class.isInstance(s)) {
            Rhomboid r = (Rhomboid) s;
            r.draw();
        }
        if (s instanceof CirCle) {

            CirCle c = (CirCle) s;
            c.draw();
        }
    }
}
