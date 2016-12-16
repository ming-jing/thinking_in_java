package ex31;

import ex29.StrGenerator;
import test.Test;
import test.TestParam;
import test.Tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by belows on 2016/12/14.
 */
public class Ex31 {
    public static void main(String[] args) {
        Random random = new Random(47);
        List<Test<List<String>>> testList = new ArrayList<>();
        testList.add(new Test<List<String>>("add") {
            @Override
            public int run(List<String> container, TestParam param) {
                for (int i=0; i<param.loops;++i) {
                        container.add(StrGenerator.create(i+1));
                }
                return param.loops;
            }
        });
        testList.add(new Test<List<String>>("get") {
            @Override
            public int run(List<String> container, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    container.get(random.nextInt(container.size()));
                }

                return param.loops;
            }
        });
        Tester tester = new Tester(ArrayList.class,testList);
        tester.run();

        List<Test<Container<String>>> tests = new ArrayList<>();
        tests.add(new Test<Container<String>>("add") {
            @Override
            public int run(Container<String> container, TestParam param) {
                for (int i=0; i<param.loops;++i) {
                        container.add(StrGenerator.create(i+1));
                }
                return param.loops ;
            }
        });
        tests.add(new Test<Container<String>>("get") {
            @Override
            public int run(Container<String> container, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    container.get(random.nextInt(container.size()));
                }

                return param.loops;
            }
        });
        tester = new Tester(Container.class,tests);
        tester.run();
    }
}
