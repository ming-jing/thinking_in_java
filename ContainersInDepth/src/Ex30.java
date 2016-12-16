import test.*;
import test.Test;
import test.TestParam;

import java.util.*;

/**
 * Created by belows on 2016/12/14.
 */
public class Ex30 {

    public static void main(String[] args) {
        List<test.Test<List<Integer>>> tests = new ArrayList<>();
        tests.add(new Test<List<Integer>>("sort") {
            @Override
            public int run(List<Integer> container, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    container.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            if (o1 > o2) {
                                return 1;
                            } else if (o1 == o2) {
                                return 0;
                            } else {
                                return -1;
                            }
                        }
                    });
                }
                return param.loops;
            }
        });
        Tester tester = new Tester(ArrayList.class,tests);
        tester.setInitContainer(new Tester.InitContainer<List<Integer>>() {
            @Override
            public List<Integer> init(TestParam param) {
                return new ArrayList<Integer>(Arrays.asList(randInts(param.size)));
            }
        });
        tester.run();


        List<Test<LinkedList<Integer>>> ts = new ArrayList<>();
        ts.add(new Test<LinkedList<Integer>>("sort") {
            @Override
            public int run(LinkedList<Integer> container, TestParam param) {
                for (int i=0; i<param.loops; ++i) {
                    container.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            if (o1 > o2) {
                                return 1;
                            } else if (o1 == o2) {
                                return 0;
                            } else {
                                return -1;
                            }
                        }
                    });
                }
                return param.loops;
            }
        });;
        tester = new Tester(LinkedList.class,ts);
        tester.setInitContainer(new Tester.InitContainer<LinkedList<Integer>>() {
            @Override
            public LinkedList<Integer> init(TestParam param) {
                return new LinkedList<Integer>(Arrays.asList(randInts(param.size)));
            }
        });
        tester.run();
    }

    static Random random = new Random(47);
    static private Integer[] randInts(int size) {
        Integer[] ints = new Integer[size];
        for (int i=0; i<size; ++i) {
            ints[i] = random.nextInt();
        }
        return ints;
    }
}
