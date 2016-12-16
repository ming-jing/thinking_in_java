package test;

import java.util.List;

/**
 * Created by belows on 2016/12/14.
 */
public abstract class Test<C> {
    public final String name;

    public Test(String name) {
        this.name = name;
    }

    public abstract int run(C container, TestParam param);
}
