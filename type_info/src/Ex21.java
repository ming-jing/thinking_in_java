/**
 * Created by belows on 2016/11/9.
 */
public class Ex21 {
    interface Interface {
        void doSomething();
        void somethingElse(String arg);
    }

    static class SimpleProxy implements Interface {

        Interface proxied;
         int doSomethingTimes = 0;
         int somethingElseTimes = 0;

        SimpleProxy(Interface proxied) {
            this.proxied = proxied;
        }

        @Override
        public void doSomething() {
            ++doSomethingTimes;

            proxied.doSomething();
        }

        @Override
        public void somethingElse(String arg) {
            ++somethingElseTimes;

            proxied.somethingElse(arg);
        }

        @Override
        public String toString() {
            return "doSomething invoke " + doSomethingTimes + " times," + "something else invoke " + somethingElseTimes + " times";
        }
    }

    static class RealObj implements Interface {
        @Override
        public void doSomething() {
            System.out.println("real do something");
        }

        @Override
        public void somethingElse(String arg) {
            System.out.println("real something else " + arg);
        }
    }

    public static void main(String[] args) {
        RealObj obj = new RealObj();
        SimpleProxy proxy = new SimpleProxy(obj);

        for (int i=0; i<10; ++i) {
            proxy.doSomething();
            if (i%2==0) {
                proxy.somethingElse("test" +i);
            }
        }
        System.out.println(proxy);
    }
}
