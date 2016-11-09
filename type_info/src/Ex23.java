import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by belows on 2016/11/9.
 */
public class Ex23 {

    interface T {
        void test();
    }

    static class ProxyHandler implements InvocationHandler {

        private Object proxied;

        public ProxyHandler(Object proxied) {
            this.proxied = proxied;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(proxy.getClass().getName());
            return method.invoke(proxied ,args);
        }
    }

    public static void main(String[] args) {
        T impl = new T() {
            @Override
            public void test() {

            }
        };
        T t = (T) Proxy.newProxyInstance(T.class.getClassLoader(),new Class[]{T.class},new ProxyHandler(impl));
        t.test();
    }
}
