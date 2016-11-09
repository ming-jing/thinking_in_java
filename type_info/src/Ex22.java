import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by belows on 2016/11/9.
 */
public class Ex22 {
    static class ProxyHandler implements InvocationHandler {

        private List<Object> proxyList = new ArrayList<>();
        ProxyHandler(List<Object> proxyList) {
            this.proxyList.addAll(proxyList);
        }

        private HashMap<String,Integer> counter = new HashMap<>();

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String methodStr = method.toString();
            Integer value = counter.get(methodStr);
            if (value == null) {
                counter.put(methodStr,1);
            } else {
                counter.put(methodStr,value+1);
            }
            for (Object proxied : proxyList) {
                method.invoke(proxied,args);
            }
            return null;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (Map.Entry<String,Integer> entry : counter.entrySet()) {
                builder.append(entry.getKey());
                builder.append(" invoke ");
                builder.append(entry.getValue());
                builder.append(" times\n");
            }
            return builder.toString();
        }
    }

    interface I1 {
        void test1(int i);
    }

    interface I2 {
        void test2(int i);
    }

    static class T implements I1,I2 {
        @Override
        public void test1(int i) {

        }

        @Override
        public void test2(int i) {

        }
    }

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add(new T());
        ProxyHandler handler = new ProxyHandler(list);
        Object obj  = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{I1.class,I2.class},handler);
        ((I1)obj).test1(34);
        ((I2)obj).test2(34);
        System.out.println(handler);
    }
}
