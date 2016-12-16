package ex29;

import test.Test;
import test.TestParam;
import test.Tester;

import java.util.*;

/**
 * Created by belows on 2016/12/14.
 */
public class Ex29 {
    public static void main(String[] args) {
        Random random = new Random(47);
        List<Test<List<String>>> tests = new ArrayList<>();

        tests.add(new Test<List<String>>("add") {
            @Override
            public int run(List<String> container, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    container.clear();
                    for (int j=0; j<param.size; ++j) {
                        container.add(StrGenerator.create(j+1));
                    }
                }
                return param.loops * param.size;
            }
        });
        tests.add(new Test<List<String>>("get") {
            @Override
            public int run(List<String> container, TestParam param) {
                int size = container.size();
                for (int i=0; i<param.loops; ++i) {
                    container.get(random.nextInt(size));
                }
                return param.loops;
            }
        });
        tests.add(new Test<List<String>>("set") {
            @Override
            public int run(List<String> container, TestParam param) {
                int size = container.size();
                for (int i=0; i<param.loops; ++i) {
                    container.set(random.nextInt(size),StrGenerator.create(i+1));
                }
                return param.loops;
            }
        });
        tests.add(new Test<List<String>>("iteradd") {
            @Override
            public int run(List<String> container, TestParam param) {
                ListIterator<String> it = container.listIterator(container.size()/2);
                for (int i=0; i<param.loops; ++i) {
                    it.add(StrGenerator.create(i+1));
                }
                return param.loops;
            }
        });
        tests.add(new Test<List<String>>("insert"){
            @Override
            public int run(List<String> container, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    container.clear();
                    for (int j=0; j<param.size; ++j) {
                        container.add(0,StrGenerator.create(j+1));
                    }
                }
                return param.loops * param.size;
            }
        });
        tests.add(new Test<List<String>>("remove") {
            @Override
            public int run(List<String> container, TestParam param) {
                int loops = container.size();
                while (!container.isEmpty()) {
                    container.remove(0);
                }
                return loops;
            }
        });
        
        Tester tester = new Tester(ArrayList.class,tests) {};
        tester.run();
    }

    private List<String> ranStrs(int size) {
        List<String> list = new ArrayList<>();

//        for (int i=0; i<size; ++i) {
//            list.add();
//        }
        return list;
    }
}
