package ex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by belows on 2016/12/26.
 */

enum Color {
    RED,WHITE,GREEN;
}

abstract class Shape implements Serializable {

    public abstract Color getColor();

    public abstract void setColor(Color color);

    private int x,y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ",x:" + x + ",y:" + y + ",color:" + getColor() + "\n";
    }
}

class Circle extends Shape {

    static Color color = Color.RED;

    public Circle(int x, int y) {
        super(x, y);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        Circle.color = color;
    }

    public static void staticWrite(ObjectOutputStream out) throws IOException {
        out.writeObject(color);
    }

    public static Object staticRead(ObjectInputStream in) throws IOException, ClassNotFoundException {
        return in.readObject();
    }
}

class Line extends Shape {

    static Color color;

    public Line(int x, int y) {
        super(x, y);
        color = Color.GREEN;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        Line.color = color;
    }

    public static void staticWrite(ObjectOutputStream out) throws IOException {
        out.writeObject(color);
    }

    public static Object staticRead(ObjectInputStream in) throws IOException, ClassNotFoundException {
        return in.readObject();
    }
}

public class Ex30 {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
//        write();
        read();
    }

    public static void write() throws IOException {
        List<Shape> shapes = new ArrayList<>();
        for (int i=0;i<10; ++i) {
            if (i%2==0) {
                Shape shape = new Circle(i,i<<4*17);
                shapes.add(shape);
                shape.setColor(Color.WHITE);
            } else {
                Shape shape = new Line(i, i<<5*17);
                shapes.add(shape);
                shape.setColor(Color.WHITE);
            }
        }
//        ByteArrayOutputStream buffer = new ByteArrayOutputStream(1024<<2);
//        ObjectOutputStream out = new ObjectOutputStream(buffer);
//        out.writeObject(shapes);
//        out.close();
//
//        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buffer.toByteArray()));
//        System.out.println(in.readObject());
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("11.txt"));
        Circle.staticWrite(out);
        Line.staticWrite(out);
        out.writeObject(shapes);
        out.close();
    }

    public static void read() throws IOException,ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("11.txt"));
        System.out.println(in.readObject());
        System.out.println(in.readObject());
        System.out.println(in.readObject());
    }
}
