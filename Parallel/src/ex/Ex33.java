package ex;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by belows on 2017/2/10.
 */
public class Ex33 {

    private abstract static class Task implements Runnable,Delayed {
        protected long delayTime;
        protected long repeatTime;
        protected long nextStartTime;
        static boolean isCanceled = false;

        public Task(long delayTime, long repeatTime) {
            this.delayTime = delayTime;
            this.repeatTime = repeatTime;
            nextStartTime = System.currentTimeMillis() + delayTime;
        }

        @Override
        public long getDelay(@NotNull TimeUnit unit) {
            return unit.convert(nextStartTime-System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(@NotNull Delayed o) {
            Task other = (Task)o;
            if (other.nextStartTime < nextStartTime) {
                return -1;
            } else if (other.nextStartTime > nextStartTime) {
                return 1;
            }
            return 0;
        }
    }

    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "Day";

    public synchronized String getThermostat() {
        return thermostat;
    }

    public synchronized void setThermostat(String value) {
        thermostat = value;
    }

    DelayQueue<Task> tasks = new DelayQueue<>();

    Lock lightLock = new ReentrantLock();
    class LightOn extends Task {

        public LightOn(long delayTime, long repeatTime) {
            super(delayTime, repeatTime);
        }

        public void run() {
            // Put hardware control code here to
            // physically turn on the light.
            while (!isCanceled) {
                lightLock.lock();
                try {
                    System.out.println("Turning on lights");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (Exception e) {
                    }
                    light = true;
                } finally {
                    lightLock.unlock();
                }

                try {
                    TimeUnit.MILLISECONDS.sleep(repeatTime);
                } catch (InterruptedException e) {}
            }
        }
    }

    class LightOff extends Task {

        public LightOff(long delayTime, long repeatTime) {
            super(delayTime, repeatTime);
        }

        public void run() {
            // Put hardware control code here to
            // physically turn off the light.
            while (!isCanceled) {
                lightLock.lock();
                try {
                    System.out.println("Turning off lights");
                    light = false;
                } finally {
                    lightLock.unlock();
                }

                try {
                    TimeUnit.MILLISECONDS.sleep(repeatTime);
                } catch (Exception e) {}
            }
        }
    }

     class WaterOn extends Task {

        public WaterOn(long delayTime, long repeatTime) {
            super(delayTime, repeatTime);
        }

        public void run() {
            // Put hardware control code here.
            while(!isCanceled) {
                System.out.println("Turning greenhouse water on");
                water = true;
                try {
                    TimeUnit.MILLISECONDS.sleep(repeatTime);
                } catch (InterruptedException e) {}
            }
        }
    }

     class WaterOff extends Task {

        public WaterOff(long delayTime, long repeatTime) {
            super(delayTime, repeatTime);
        }

        public void run() {
            // Put hardware control code here.
            while (!isCanceled) {
                System.out.println("Turning greenhouse water off");
                water = false;

                try {
                    TimeUnit.MILLISECONDS.sleep(repeatTime);
                } catch (InterruptedException e) {}
            }
        }
    }

     class ThermostatNight extends Task {

        public ThermostatNight(long delayTime, long repeatTime) {
            super(delayTime, repeatTime);
        }

        public void run() {
            // Put hardware control code here.
            while (!isCanceled) {
                System.out.println("Thermostat to night setting");
                setThermostat("Night");

                try{
                    TimeUnit.MILLISECONDS.sleep(repeatTime);
                } catch (InterruptedException e) {}
            }
        }
    }

     class ThermostatDay extends Task {

        public ThermostatDay(long delayTime, long repeatTime) {
            super(delayTime, repeatTime);
        }

        public void run() {
            // Put hardware control code here.
            while (!isCanceled) {
                System.out.println("Thermostat to day setting");
                setThermostat("Day");

                try {
                    TimeUnit.MILLISECONDS.sleep(repeatTime);
                } catch (InterruptedException e) {}
            }
        }
    }

     class Bell extends Task {

        public Bell(long delayTime, long repeatTime) {
            super(delayTime, repeatTime);
        }

        public void run() {
            while (!isCanceled) {
                System.out.println("Bing!");

                try {
                    TimeUnit.MILLISECONDS.sleep(repeatTime);
                } catch (InterruptedException e) {}
            }
        }
    }

     class Terminate extends Task {

        public Terminate(long delayTime, long repeatTime) {
            super(delayTime, repeatTime);
        }

        public void run() {
            System.out.println("Terminating");
//                scheduler.shutdownNow();
            // Must start a separate task to do this job,
            // since the scheduler has been shut down:
            new Thread() {
                public void run() {
                    for (DataPoint d : data)
                        System.out.println(d);
                }
            }.start();
        }
    }

    // New feature: data collection
    static class DataPoint {
        final Calendar time;
        final float temperature;
        final float humidity;

        public DataPoint(Calendar d, float temp, float hum) {
            time = d;
            temperature = temp;
            humidity = hum;
        }

        public String toString() {
            return time.getTime() +
                    String.format(
                            " temperature: %1$.1f humidity: %2$.2f",
                            temperature, humidity);
        }
    }

    private Calendar lastTime = Calendar.getInstance();

    { // Adjust date to the half hour
        lastTime.set(Calendar.MINUTE, 30);
        lastTime.set(Calendar.SECOND, 00);
    }

    private float lastTemp = 65.0f;
    private int tempDirection = +1;
    private float lastHumidity = 50.0f;
    private int humidityDirection = +1;
    private Random rand = new Random(47);
    List<DataPoint> data = //new ArrayList<>();
            Collections.synchronizedList(new ArrayList<DataPoint>());

    class CollectData implements Runnable {
        public void run() {
            System.out.println("Collecting data");
            synchronized (this) {
                // Pretend the interval is longer than it is:
                lastTime.set(Calendar.MINUTE,
                        lastTime.get(Calendar.MINUTE) + 30);
                // One in 5 chances of reversing the direction:
                if (rand.nextInt(5) == 4)
                    tempDirection = -tempDirection;
                // Store previous value:
                lastTemp = lastTemp +
                        tempDirection * (1.0f + rand.nextFloat());
                if (rand.nextInt(5) == 4)
                    humidityDirection = -humidityDirection;
                lastHumidity = lastHumidity +
                        humidityDirection * rand.nextFloat();// Calendar must be cloned, otherwise all
                // DataPoints hold references to the same lastTime.
                // For a basic object like Calendar, clone() is OK.
                data.add(new DataPoint((Calendar) lastTime.clone(),
                        lastTemp, lastHumidity));
            }
        }
    }

    public static void main(String[] args) {
        Ex33 gh = new Ex33();
//            gh.schedule(gh.new Terminate(), 500);
//            // Former "Restart" class not necessary:
//            gh.repeat(gh.new Bell(), 0, 1000);
//            gh.repeat(gh.new ThermostatNight(), 0, 2000);
//            gh.repeat(gh.new LightOn(), 0, 2000);
//            gh.repeat(gh.new LightOff(), 0, 4000);
//            gh.repeat(gh.new WaterOn(), 0, 600);
//            gh.repeat(gh.new WaterOff(), 0, 800);
//            gh.repeat(gh.new ThermostatDay(), 0, 1400);
//            gh.repeat(gh.new CollectData(), 500, 500);

        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(gh.new Terminate(500,0));
        exec.execute(gh.new Bell(0,30));
        exec.execute(gh.new ThermostatNight(0,20));
        exec.execute(gh.new LightOn(0,50));
        exec.execute(gh.new LightOff(0,30));
        exec.execute(gh.new WaterOn(0,50));
        exec.execute(gh.new WaterOff(0,80));
        exec.execute(gh.new ThermostatDay(0,40));
        exec.execute(gh.new CollectData());
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println(gh.light);
            Task.isCanceled = true;
        } catch (Exception e) {}


    }
}
