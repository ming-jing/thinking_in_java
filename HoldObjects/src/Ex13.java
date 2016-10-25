import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by belows on 2016/10/25.
 */

abstract class Event {
    private long eventTime;

    public Event(long delayTime) {
        start(delayTime);
    }

    public void start(long delayTime) {
        eventTime = System.currentTimeMillis() + delayTime;
    }

    public boolean ready() {
        return eventTime < System.currentTimeMillis();
    }

    abstract void action();
}

public class Ex13 {

    static class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        void action() {
            System.out.println("Light On");
        }
    }

    static class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        void action() {
            System.out.println("Light Off");
        }
    }

    static class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        void action() {
            System.out.println("Water On");
        }
    }

    static class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        void action() {
            System.out.println("Water Off");
        }
    }

    static class Restart extends Event {
        public Restart(long delayTime) {
            super(delayTime);
        }

        @Override
        void action() {

        }
    }

    public static void main(String[] args) {
        LinkedList<Event> events = new LinkedList<>();
        events.add(new LightOn(1000));
        events.add(new LightOff(2000));
        events.add(new WaterOn(50));
        events.add(new WaterOff(300));

        while (!events.isEmpty()) {
            ListIterator<Event> it = events.listIterator(0);
            while (it.hasNext()) {
                Event event = it.next();
                if (event.ready()) {
                    event.action();
                    it.remove();
                }
            }
        }
    }
}
