import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by belows on 2016/11/15.
 */
public class Ex39 {
    interface IT1 {
        void test1();
    }

    interface IT2 {
        void test2();
    }

    interface  IT3 {
        void test3();
    }

    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        };
        Object obj = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{IT1.class,IT2.class,IT3.class},handler);
        IT1 it1 = (IT1)obj;
        IT2 it2 = (IT2) obj;
        IT3 it3 = (IT3) obj;

        it1.test1();
        it2.test2();
        it3.test3();
    }
}
