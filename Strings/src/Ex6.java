/**
 * Created by belows on 2016/11/3.
 */


public class Ex6 {

    static class Test {
        int i;
        long l;
        float f;
        double d;

        Test(int i, long l , float f, double d) {
            this.i = i;
            this.l = l;
            this.f = f;
            this.d = d;
        }

        @Override
        public String toString() {
            return String.format("%d %d %.3f %.3f",i,l,f,d);
        }
    }
    public static void main(String[] args) {
        Test t = new Test(1,1000000000010l,1.3f,2.7d);
        System.out.println(t);
    }
}
