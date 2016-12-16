import test.*;
import test.TestParam;

import java.util.HashMap;

/**
 * Created by belows on 2016/12/15.
 */
public class Ex38 {
    public static void main(String[] args) {
        Tester tester = new Tester(HashMap.class,Ex37.tests);
        tester.setInitContainer(new Tester.InitContainer<HashMap>() {
            @Override
            public HashMap init(test.TestParam param) {
                return new HashMap(1024000,0.75f);
            };
        });
        tester.run();

        tester.setInitContainer(new Tester.InitContainer() {
            @Override
            public Object init(TestParam param) {
                return new HashMap();
            }
        });
        tester.run();
    }
}
