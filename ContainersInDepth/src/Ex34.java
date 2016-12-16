import ex29.StrGenerator;
import test.*;
import test.Test;
import test.TestParam;

import java.util.*;

/**
 * Created by belows on 2016/12/15.
 */
public class Ex34 {
    public static void main(String[] args) {
        Random random = new Random(47);
        int maxLen = 10;

        List<test.Test<Set<String>>> tests = new ArrayList<>();
        tests.add(new Test<Set<String>>("add") {
            @Override
            public int run(Set<String> container, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    container.clear();
                    for (int j=0; j<param.size; ++j) {
                        container.add(StrGenerator.create(random.nextInt(maxLen)) + 5);
                    }
                }
                return param.loops * param.size;
            }
        });
        tests.add(new Test<Set<String>>("contains") {
            @Override
            public int run(Set<String> container, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    for (int j=0; j<param.size; ++j) {
                        container.contains(StrGenerator.create(random.nextInt(maxLen)) + 5);
                    }
                }

                return param.loops * param.size;
            }
        });
        tests.add(new Test<Set<String>>("iterator") {
            @Override
            public int run(Set<String> container, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    Iterator<String> it = container.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                return param.loops * container.size();
            }
        });

        Tester tester = new Tester(HashSet.class,tests);
        tester.run();

        tester = new Tester(TreeSet.class,tests);
        tester.run();

        tester = new Tester(LinkedHashSet.class, tests);
        tester.run();
    }
}
