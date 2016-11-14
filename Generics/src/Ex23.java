/**
 * Created by belows on 2016/11/11.
 */
public class Ex23 {
    interface IFactory<T> {
        T create(Object... args);
    }

    static class IntegerFactory implements IFactory<Integer> {
        @Override
        public Integer create(Object... args) {
            if (args[0] instanceof Number) {
                return Integer.parseInt( args[0].toString());
            } else {
                return Integer.MIN_VALUE;
            }
        }
    }

    public static void main(String[] args) {
        IntegerFactory integerFactory = new IntegerFactory();
        int i = integerFactory.create(3.7);
        System.out.println(i);
    }
}
