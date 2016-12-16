package test;

import java.util.*;

/**
 * Created by belows on 2016/12/14.
 */
public class Tester<C> {

    public static final int width = 12;
    public static final int repeats = 1000;

    public List<Test<C>> tests;
    public List<TestParam> params = Arrays.asList(TestParam.defaultParams);
    public Class<C> cls;
    public String title;

    public String strFormat(String s) {
        return String.format("%" + width + "s", s);
    }

    public String intFormat(long i) {
        return String.format("%" + width + "d", i);
    }

    public Tester(Class<C> cls, List<Test<C>> tests) {
        this.cls = cls;
        this.tests = tests;
    }

    public Tester(Class<C> cls, List<Test<C>> tests, List<TestParam> params) {
        this(cls, tests);
        this.params = params;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private void displayTitle() {
        StringBuilder builder = new StringBuilder();
        builder.append(strFormat("size"));
        for (Test<C> test : tests) {
            builder.append(strFormat(test.name));
        }

        String title = this.title == null ? cls.getSimpleName() : this.title;
        int len = (builder.length() - title.length()) / 2;
        builder.insert(0, "\n");
        for (int i = 0; i < len; ++i) {
            builder.insert(0, '-');
        }
        builder.insert(0, title);
        for (int i = 0; i < len; ++i) {
            builder.insert(0, '-');
        }
        System.out.println(builder.toString());
    }

    private C container;
    public void run() {
        displayTitle();
        
        StringBuilder builder = new StringBuilder();
        for (TestParam param : params) {
            if (initContainer != null) {
                container = initContainer.init(param);
            }
             else {
                 try {
                    container = cls.newInstance();
                } catch (Exception e) {
                    System.out.println(e);
                 }
            }
            builder.delete(0,builder.length());
            builder.append(intFormat(param.size));
            for (Test<C> test : tests) {
                long start = System.nanoTime();
                int steps = test.run(container,param);
                long duration = System.nanoTime() - start;
                builder.append(intFormat(duration/steps));
            }
            System.out.println(builder.toString());
        }
    }

    InitContainer<C> initContainer = null;
    public void setInitContainer(InitContainer<C> initContainer) {
        this.initContainer = initContainer;
    }

    public interface InitContainer<C> {
        C init(TestParam param);
    }

    static         Random rand = new Random(47);

    public static void main(String[] args) {


        List<Test<List<Integer>>> tests = new ArrayList<>();

        tests.add(new Test<List<Integer>>("add") {
            @Override
            public int run(List<Integer> container, TestParam params) {
                for (int i=0; i<params.loops; ++i) {
                    container.clear();
                    for (int j=0; j<params.size; ++j ){
                        container.add(j);
                    }
                }
                return params.size * params.loops;
            }
        });
        tests.add(new Test<List<Integer>>("get") {
            @Override
            public int run(List<Integer> container, TestParam params) {
                int size = container.size();
                int loops = params.loops * repeats;

                for (int i=0; i<loops; ++i) {
                    container.get(rand.nextInt(size));
                }
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("set") {
            @Override
            public int run(List<Integer> container, TestParam params) {
                int size = container.size();
                int loops = params.loops * repeats;

                for (int i=0; i<loops; ++i) {
                    container.set(rand.nextInt(size),47);
                }
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("iteradd") {
            @Override
            public int run(List<Integer> container, TestParam params) {
                container.clear();
                ListIterator<Integer> it = container.listIterator(container.size()/2);
//                int loops = params.loops * repeats;
                int loops = 1000000;
                for (int i=0; i<loops; ++i) {
                    it.add(new Integer(i));
                }
                return loops;
            }
        });
        tests.add(new Test<List<Integer>>("insert") {
            @Override
            public int run(List<Integer> container, TestParam params) {
                int loops = params.loops ;

                for (int i=0;i<loops; ++i) {
                    container.clear();
                    for (int j=0; j<params.size; ++j) {
                        container.add(container.size() / 2, j);
                    }
                }
                return loops*params.size;
            }
        });
        tests.add(new Test<List<Integer>>("remove") {
            @Override
            public int run(List<Integer> container, TestParam params) {
                for (int i=0; i<params.loops; ++i) {
                    container.clear();
                    container.addAll(Arrays.asList(ranInts(params.size)));
                    while (!container.isEmpty()) {
                        container.remove(0);
                    }
                }
                return params.loops * params.size;
            }
        });

        Tester tester = new Tester(ArrayList.class,tests);
        tester.run();
    }

    static Integer[] ranInts(int size) {
        Integer[] array = new Integer[size];
        for (int i=0; i<size; ++i) {
            array[i] = rand.nextInt();
        }

        return array;
    }
}
