import test.*;
import test.Test;
import test.TestParam;

import java.util.*;

/**
 * Created by belows on 2016/12/14.
 */

public class Ex33 {
    public static void main(String[] args) {
        List<test.Test<List<Integer>>> tests = new ArrayList<>();
        Random random = new Random(47);
        
        tests.add(new Test<List<Integer>>("add") {
            @Override
            public int run(List<Integer> FastList, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    FastList.clear();
                    for (int j=0; j<param.size; ++j) {
                        FastList.add(j);
                    }
                }
                return param.size * param.loops;
            }
        });
        tests.add(new Test<List<Integer>>("get") {
            @Override
            public int run(List<Integer> FastList, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    for (int j=0; j<param.size; ++j) {
                        FastList.get(random.nextInt(FastList.size()));
                    }
                }
                return param.loops * param.size;
            }
        });
        tests.add(new Test<List<Integer>>("remove") {
            @Override
            public int run(List<Integer> FastList, TestParam param) {
                int size = FastList.size();
                while (!FastList.isEmpty()) {
                    FastList.remove(0);
                }
                return size;
            }
        });
        
        Tester tester = new Tester(ArrayList.class,tests);
        tester.run();
        
        List<Test<FastList<Integer>>> testList = new ArrayList<>();
        testList.add(new Test<FastList<Integer>>("add") {
            @Override
            public int run(FastList<Integer> FastList, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    FastList.clear();
                    for (int j=0; j<param.size; ++j) {
                        FastList.add(j);
                    }
                }
                return param.size * param.loops;
            }
        });
        testList.add(new Test<FastList<Integer>>("get") {
            @Override
            public int run(FastList<Integer> FastList, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    for (int j=0; j<param.size; ++j) {
                        FastList.get(random.nextInt(FastList.size()));
                    }
                }
                return param.loops * param.size;
            }
        });
        testList.add(new Test<FastList<Integer>>("remove") {
            @Override
            public int run(FastList<Integer> FastList, TestParam param) {
                int size = FastList.size();
                while (FastList.size()!=0) {
                    FastList.remove(0);
                }
                return size;
            }
        });
        tester = new Tester(FastList.class,testList);
        tester.run();
    }
}
