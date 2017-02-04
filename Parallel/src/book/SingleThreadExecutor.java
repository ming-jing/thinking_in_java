package book;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by belows on 2017/1/4.
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService exec =
                Executors.newSingleThreadExecutor();
        for(int i = 0; i < 5; i++)
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
