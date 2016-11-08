import java.util.Arrays;
import java.util.List;

/**
 * Created by belows on 2016/11/7.
 */



public class Ex5 {
    abstract static class Shape {
        void draw() { System.out.println(this + ".draw()"); }
        void rotate() {
            System.out.println(this+".rotate()");
        }

        abstract public String toString();

    }
    static class Circle extends Shape {
        public String toString() { return "Circle"; }
    }
    static class Square extends Shape {
        public String toString() { return "Square"; }
    }
    static class Triangle extends Shape {
        public String toString() { return "Triangle"; }
    }
    static class Shapes {

         static void  rotate(List<Shape> shapes) {
            for (Shape shape : shapes) {
                if (!(shape instanceof Circle)) {
                    shape.rotate();
                }
            }
        }

        public static void main(String[] args) {
            List<Shape> shapeList = Arrays.asList(
                    new Circle(), new Square(), new Triangle()
            );
            for(Shape shape : shapeList)
                shape.draw();

            rotate(shapeList);
        }
    }

    public static void main(String[] args) {
        Shapes.main(args);
    }
}
