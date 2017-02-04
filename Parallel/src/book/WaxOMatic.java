package book;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by belows on 2017/1/10.
 */
class Car {
    private boolean waxOn = false;

    public synchronized void waxed() {
        waxOn = true; // Ready to buff
        notify();
    }

    public synchronized void buffed() {
        waxOn = false; // Ready for another coat of wax
        notify();
    }

    public synchronized void waitForWaxing()
            throws InterruptedException {
        while (waxOn == false)
        wait();
    }

    public synchronized void waitForBuffing()
            throws InterruptedException {
        while (waxOn == true)
            wait();
    }
}

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car c) {
        car = c;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.print("Wax On! ");
                TimeUnit.MILLISECONDS.sleep(500);
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax On task");
    }
}

class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car c) {
        car = c;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitForWaxing();
                System.out.print("Wax Off! ");
                TimeUnit.MILLISECONDS.sleep(500);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax Off task");
    }
}

public class WaxOMatic {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOn(car));
        exec.execute(new WaxOff(car));
        TimeUnit.SECONDS.sleep(5); // Run for  a while...
        exec.shutdownNow(); // Interrupt all tasks
    }
}


//class Car2{
//    private boolean waxOn = false;
//    public synchronized void waxed(){
//        waxOn = true;
////        System.out.println("function waxed");
//        notifyAll();
//    }
//    public synchronized void buffed(){
//        waxOn = false;
////        System.out.println("function buffed");
//        notifyAll();
//    }
//    public synchronized void waitForWaxing() throws InterruptedException{
////        System.out.println("function waitforwaxing");
//        while(waxOn == false){
////            System.out.println("waitforwaxing");
//            wait();
//        }
//    }
//    public synchronized void waitForBuffing() throws InterruptedException{
////        System.out.println("function waitforbuffing");
//        while(waxOn == true){
////            System.out.println("waitforbuffing");
//            wait();
//        }
//    }
//}
//
//class WaxOn2 implements Runnable{
//    private Car2 car;
//    public WaxOn2(Car2 c){
//        car = c;
//    }
//    @Override
//    public void run() {
//        // TODO Auto-generated method stub
//        try{
//            while(!Thread.interrupted()){
//                System.out.print("Wax On ");
//                TimeUnit.MILLISECONDS.sleep(500);
////				TimeUnit.SECONDS.sleep(5);
//                car.waxed();
//                car.waitForBuffing();
//            }
//        }catch(InterruptedException e){
//            System.out.println("Exit via interrupt");
//        }
//        System.out.println("Ending Wax On task");
//    }
//
//}
//
//class WaxOff2 implements Runnable{
//    private Car2 car;
//
//    public WaxOff2(Car2 c){
//        car = c;
//    }
//    @Override
//    public void run() {
//        // TODO Auto-generated method stub
//        try{
//            while(!Thread.interrupted()){
//                car.waitForWaxing();
//                System.out.print("Wax Off ");
//                TimeUnit.MILLISECONDS.sleep(500);
//                car.buffed();
//            }
//        }catch(InterruptedException e){
//            System.out.println("Exit via interrupt");
//        }
//        System.out.println("Ending Wax Off task");
//    }
//
//}
//
//public class WaxOMatic2 {
//
//    public static void main(String[] args) throws Exception{
//        // TODO Auto-generated method stub
//        Car2 car = new Car2();
//        ExecutorService exec = Executors.newCachedThreadPool();
//        exec.execute(new WaxOn2(car));
//        exec.execute(new WaxOff2(car));
////		exec.execute(new WaxOff(car));
////		exec.execute(new WaxOn(car));
//        TimeUnit.SECONDS.sleep(5);
//        exec.shutdownNow();
//    }
//
//}
