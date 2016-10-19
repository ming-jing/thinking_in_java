/**
 * created by belows on 16/10/16.
 */

class glyph {
    void draw() { System.out.println("glyph.draw()"); }
    glyph() {
        System.out.println("glyph() before draw()");
        draw();
        System.out.println("glyph() after draw()");
    } 
}
    
class rectangularglyph extends glyph {
    int width = 3;
    int height = 5;

    @Override
    void draw() {
        System.out.println("rectangle draw, width="+width+",height=" + height);
    }
}

public class Ex15 {
    public static void main(String[] args) {
        new rectangularglyph().draw();
    }
}
