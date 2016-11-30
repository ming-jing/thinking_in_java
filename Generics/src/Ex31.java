/**
 * Created by belows on 2016/11/14.
 */
public class Ex31 {
    interface Payable<T> {}
    static class Employee implements Payable {}
    static class Hourly extends Employee
            implements Payable {}
}
