package ex6.t3;

import ex6.t2.Test;

/**
 * Created by belows on 2016/10/19.
 */
public class TT extends Test {
    public ex6.t1.inter getInter() {
        return new ex6.t2.Test.Inner();
    }

    public static void main(String[] args) {}
}
