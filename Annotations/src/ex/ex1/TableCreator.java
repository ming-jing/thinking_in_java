package ex.ex1;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by belows on 2017/1/3.
 */
public class TableCreator {
    public static void create(String clsName) throws ClassNotFoundException {
        Class<?> cls = Class.forName(clsName);
        DBTable db = cls.getAnnotation(DBTable.class);
        String dbName = db.name();
        if (db == null) {
            return;
        }
        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
            Annotation[] as = f.getDeclaredAnnotations();
            for (Annotation annotation : as) {
                if (annotation instanceof SQLString) {

                } else if (annotation instanceof SQLInt) {

                }
            }
        }
    }
}
