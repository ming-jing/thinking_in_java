package ex;

import com.sun.org.apache.regexp.internal.RE;

import static ex.Signal.*;
/**
 * Created by belows on 2016/12/27.
 */


class TrafficLight {
    Signal color = RED;

    @Override
    public String toString() {
        return "The traffic light is " + color;
    }

    void change() {
        switch (color) {
            case GREEN:
                color = YELLOW;
                break;
            case YELLOW:
                color = RED;
                break;
            case RED:
                color = GREEN;
                break;
        }
    }
}

public class Ex1 {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        for (int i=0; i<7;++i) {
            System.out.println(light);
            light.change();
        }
    }
}
