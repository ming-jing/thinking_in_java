import java.util.Random;

/**
 * Created by belows on 16/10/16.
 */

class Shape {
    public void draw() {}
    public void erase() {}
    public void test() {
        System.out.println("Shape.test()");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Circle.erase()");
    }

    @Override
    public void test() {
        System.out.println("Circle.test()");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Square.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Square.erase()");
    }

    @Override
    public void test() {
        System.out.println("Square.test()");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Triangle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Triangle.erase()");
    }

    @Override
    public void test() {
        System.out.println("Triangle.test()");
    }
}

class Line extends Shape {
    @Override
    public void draw() {
        System.out.println("Line.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Line.erase()");
    }

    @Override
    public void test() {
        System.out.println("Line.test()");
    }
}
class RandomShapeGenerator {
    public static Random random = new Random();
    public static Shape next() {
        int index = random.nextInt(4);
        switch (index) {
            default:
            case 0:
                return new Circle();
            case 1:
                return new Square();
            case 2:
                return new Triangle();
            case 3:
                return new Line();
        }
    }
}

public class Ex2  {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[9];
        for (int i=0; i<9; ++i) {
            shapes[i] = RandomShapeGenerator.next();
        }
        for (Shape shape : shapes) {
            shape.draw();
            shape.erase();
            shape.test();
        }
    }
}
