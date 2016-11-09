import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by belows on 2016/11/9.
 */
public class SimpleDynamicProxy {
    interface I1 {
        void test(int i);
    }

    interface I2 {
        void test2(int i);
    }


    static class ProxyHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(proxy.getClass().getName());
            System.out.println(method);
            System.out.println(Arrays.toString(args));
            return null;
        }
    }

    public static void main(String[] args) {

        Object obj =  Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{I1.class,I2.class},new ProxyHandler());
        ((I1)obj).test(3);
        ((I2)obj).test2(34);
    }
}
