package book;

/**
 * Created by belows on 2016/12/27.
 */
enum Signal { GREEN, YELLOW, RED, }
public class TrafficLight {
    Signal color = Signal.RED;
    public void change() {
        switch(color) {
            // Note that you don’t have to say Signal.RED
            // in the case statement:
            case RED:    color = Signal.GREEN;
                return;
            case GREEN:  color = Signal.YELLOW;
                break;
            case YELLOW: color = Signal.RED;
                break;
        } }
    public String toString() {
        return "The traffic light is " + color;
    }
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for(int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }
}
