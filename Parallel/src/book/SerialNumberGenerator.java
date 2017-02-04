package book;

/**
 * Created by belows on 2017/1/6.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public static synchronized int nextSerialNumber() {
        return serialNumber++; // Not thread-safe
    }
}
