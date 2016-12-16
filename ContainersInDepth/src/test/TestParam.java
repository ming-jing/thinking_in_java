package test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by belows on 2016/12/14.
 */
public class TestParam {

    public final int size;
    public final int loops;

    public static TestParam[] defaultParams = array(10, 5000, 100, 5000, 1000, 1000, 10000, 200);

    public TestParam(int size, int loops) {
        this.size = size;
        this.loops = loops;
    }

    @Override
    public String toString() {
        return "size:" + size + ",loops:" + loops;
    }

    public static TestParam[] array(int ...ints) {
        int size = ints.length/2;
        TestParam[] params = new TestParam[size];

        for (int i=0;i<size;++i) {
            int index = i<<1;
            params[i] = new TestParam(ints[index],ints[index+1]);
        }

        return params;
    }

    public static List<TestParam> list(int ...ints) {
        return Arrays.asList(array(ints));
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(defaultParams));
        System.out.println(Arrays.toString(array(10, 5000, 100, 5000, 1000, 1000, 10000, 200)));
        System.out.println(list(10, 5000, 100, 5000, 1000, 1000, 10000, 200));
    }
}
