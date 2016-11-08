import java.util.Arrays;
import java.util.List;

/**
 * Created by belows on 2016/11/7.
 */
public class Ex6 {

    abstract static class Shape {
        boolean highLight = false;
        
        void draw() { System.out.println(this + ".draw()"); }
        void rotate() {
            System.out.println(this+".rotate()");
        }

        abstract public String toString();

    }
    static class Circle extends Shape {
        public String toString() { return "Circle,HighLight="+highLight; }
    }
    static class Square extends Shape {
        public String toString() { return "Square,HighLight="+highLight; }
    }
    static class Triangle extends Shape {
        public String toString() { return "Triangle,HighLight="+highLight; }
    }
    static class Shapes {

        static void  rotate(List<Shape> shapes) {
            for (Shape shape : shapes) {
                if (!(shape instanceof Circle)) {
                    shape.rotate();
                }
            }
        }

        static void highLight(List<Shape> shapes, Class<? extends Shape> shapeClass) {
            for (Shape shape : shapes) {
                if (shapeClass.isInstance(shape)) {
                    shape.highLight = true;
                }
            }
            System.out.println(shapes);
        }

        public static void main(String[] args) {
            List<Shape> shapeList = Arrays.asList(
                    new Circle(), new Square(), new Triangle()
            );
//            for(Shape shape : shapeList)
//                shape.draw();
//
//            rotate(shapeList);
            highLight(shapeList,Circle.class);
        }
    }
    
    public static void main(String[] args) {
        Shapes.main(args);
    }
}
