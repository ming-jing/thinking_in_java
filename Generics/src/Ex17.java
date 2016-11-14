import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Spliterator;

/**
 * Created by belows on 2016/11/10.
 */
public class Ex17 {

    enum  Type {
        Mon,Tur,Thir
    }

    interface  T {}

    static class ProxyHandler implements InvocationHandler {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }

    public static void main(String[] args) {
        EnumSet<Type> set = EnumSet.range(Type.Mon,Type.Thir);
        EnumSet<Type> s1 = set.clone();
        System.out.println(s1);

        T t = (T) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{T.class},new ProxyHandler());
    }


}
