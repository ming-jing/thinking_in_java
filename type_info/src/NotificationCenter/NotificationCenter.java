package NotificationCenter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by belows on 2016/11/9.
 */
public enum NotificationCenter {
    INSTANCE;

    private Set<Object> mObservers = new HashSet<>();
    private HashMap<Class,Notification> mNotifications = new HashMap<Class, NotificationCenter.Notification>();

    NotificationCenter() {

    }

    public void addObserver(Object obj) {
        mObservers.add(obj);
    }

    public void removeObserver(Object obj) {
        mObservers.remove(obj);
    }

    public <T> T getObserver(Class<T> cls) {
        Notification<T> notification = mNotifications.get(cls);
        if (notification == null) {
            notification = new Notification<T>(mObservers,cls);
            mNotifications.put(cls,notification);
        }
        return notification.getProxy();
    }

    private static class Notification<T> implements InvocationHandler {

        private Set<Object> mObservers;
        private Class<T> mCallback;

        public Notification(Set<Object> observers, Class<T> callback) {
            mObservers = observers;
            mCallback = callback;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            for (Object observer : mObservers) {
                if (mCallback.isInstance(observer)) {
                    method.invoke(observer,args);
                }
            }
            return null;
        }

        T mProxy = null;

        private T getProxy() {
            if (mProxy == null) {
                mProxy = (T)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{mCallback},this);
            }

            return mProxy;
        }
    }


}
