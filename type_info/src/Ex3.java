/**
 * Created by belows on 2016/11/7.
 */
public class Ex3 {

    public static class Shape {

    }

    public static class Circle extends Shape {

    }

    public static class Rhomboid extends Shape {

    }

    public static void main(String[] args) {
        Shape shape = new Rhomboid();
        if (shape instanceof Rhomboid) {
            Rhomboid r = (Rhomboid) shape;
            System.out.println("cast to Rhomboid");
        }
        if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            System.out.println("cast to Circle");
        }
    }
}
