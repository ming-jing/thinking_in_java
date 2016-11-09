package Ex25;

import Ex25.test.Test;

import java.lang.reflect.Method;

/**
 * Created by belows on 2016/11/9.
 */
public class Ex25 {
    public static void main(String[] args) throws Exception {
        Test test = new Test();
        Method method = test.getClass().getDeclaredMethod("privateTest");
        method.setAccessible(true);
        method.invoke(test);

        method = test.getClass().getDeclaredMethod("protectedTest");
        method.setAccessible(true);
        method.invoke(test);

        method = test.getClass().getDeclaredMethod("packageTest");
        method.setAccessible(true);
        method.invoke(test);
    }
}
