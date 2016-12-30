package book;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by belows on 2016/12/28.
 */
public enum ConstantSpecificMethod {
    DATE_TIME {
        String getInfo() {
            return
                    DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        String getInfo() {
            return System.getenv("PATH");
        }
    }, VERSION {
        String getInfo() {
            return System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values())
            System.out.println(csm.getInfo());
    }
}
