import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by belows on 2016/10/24.
 */

abstract class  Event {
    private long eventTime;
    private long delayTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public void start() {
        eventTime = System.nanoTime() + eventTime;
    }

    public boolean ready() {
      return   System.nanoTime() >= eventTime;
    }

    abstract void action();
}

class Controller {
    List<Event> events = new ArrayList<>();
    public void addEvent(Event event) {
        events.add(event);
    }

    public void run() {
        List<Event> localEvents = new ArrayList<>(events);
        while (true) {
            Iterator<Event> ei = localEvents.iterator();
            while (ei.hasNext()) {
                Event event = ei.next();
                if (event.ready()) {
                    event.action();
                    ei.remove();
                }
            }
            if(localEvents.isEmpty()) {
                break;
            }
        }
    }
}

 class GreenhouseController extends Controller {
     class LightOn extends Event {

        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        void action() {
            System.out.println("Light on");
        }
    }

     class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        void action() {
            System.out.println("Light Off");
        }
    }

     class Restart extends Event {
        public Restart(long delayTime) {
            super(delayTime);
        }

        @Override
        void action() {

            System.out.println("restart");
        }
    }
}

public class Ex24 {

    public static void main(String[] args) {
        GreenhouseController controller = new GreenhouseController();
        controller.addEvent(controller.new LightOn(300));
        controller.addEvent(controller.new LightOff(600));
        controller.addEvent(controller.new Restart(10000));
        controller.run();
    }
}
