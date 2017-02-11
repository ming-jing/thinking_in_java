package ex;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * Created by belows on 2017/2/10.
 */
public class Ex35 {

    interface Generator<T> {
        T next();
    }

    private static class ClientGenerator implements Generator<WebClient>, Runnable {

        public BlockingDeque<WebClient> clients = null;
        private static Random random = new Random(47);

        public ClientGenerator(BlockingDeque<WebClient> clients) {
            this.clients = clients;
        }

        @Override
        public WebClient next() {
            Random random = new Random(System.currentTimeMillis());
            return new WebClient(random.nextInt(250) + 50);
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    clients.put(next());
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(300));
                }
            } catch (InterruptedException e) {}
        }
    }

    private static class WebClient {
        private static int index = 0;
        private final int id = ++index;

        private long serverTime;

        public WebClient(long serverTime) {
            this.serverTime = serverTime;
        }
    }

    private static class Server implements Runnable {

        private BlockingDeque<WebClient> clients;
        private boolean isServing = false;
        private int serverNumber = 0;

        public Server(BlockingDeque<WebClient> clients) {
            this.clients = clients;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    WebClient client = clients.take();
                    TimeUnit.MILLISECONDS.sleep(client.serverTime);

                    synchronized (this) {
                        ++serverNumber;

                    }
                }
            } catch (InterruptedException e) {}
        }

        public synchronized void stop() {

        }

        public synchronized void restart() {

        }
    }

    public static void main(String[] args) {

    }
}
