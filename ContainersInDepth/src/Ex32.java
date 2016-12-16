import ex31.Container;
import test.*;
import test.Test;
import test.TestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by belows on 2016/12/14.
 */
public class Ex32 {
    public static void main(String[] args) {
        Random random = new Random(47);
        List<test.Test<List<Integer>>> tests = new ArrayList<>();
        tests.add(new Test<List<Integer>>("add") {
            @Override
            public int run(List<Integer> container, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    container.clear();
                    for (int j=0; j<param.size; ++j) {
                        container.add(j);
                    }
                }
                return param.loops * param.size;
            }
        });
        tests.add(new Test<List<Integer>>("get") {
            @Override
            public int run(List<Integer> container, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    container.get(random.nextInt(container.size()));
                }
                return param.loops;
            }
        });
        Tester tester = new Tester(ArrayList.class,tests);
        tester.run();

        List<Test<Container<Integer>>> testList = new ArrayList<>();
        testList.add(new Test<Container<Integer>>("add") {
            @Override
            public int run(Container<Integer> container, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    container.clear();
                    for (int j=0; j<param.size; ++j) {
                        container.add(j);
                    }
                }
                return param.loops * param.size;
            }
        });
        testList.add(new Test<Container<Integer>>("get") {
            @Override
            public int run(Container<Integer> container, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    container.get(random.nextInt(container.size()));
                }
                return param.loops;
            }
        });
        tester = new Tester(Container.class,testList);
        tester.run();
    }
}
