package book;

import java.util.concurrent.ThreadFactory;

/**
 * Created by belows on 2017/1/4.
 */
public class DaemonThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
