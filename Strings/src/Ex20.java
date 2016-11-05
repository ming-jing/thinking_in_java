import java.util.Scanner;

/**
 * Created by belows on 2016/11/5.
 */
public class Ex20 {
    static class Test {
        int i;
        long l;
        float f;
        double d;
        String s;

        Test(String s) {
            Scanner scanner = new Scanner(s);
            this.i = scanner.nextInt();
            this.l = scanner.nextLong();
            this.f = scanner.nextFloat();
            this.d = scanner.nextDouble();
            this.s = scanner.next();
        }

        @Override
        public String toString() {
            return "i:" +i + ",l:"+l+",f:"+f+",d:"+d+",s:"+s;
        }
    }
    public static void main(String[] args) {
//        int, long, float and double and String
        Test t = new Test("3 500 3.7 0.21834 test");
        System.out.println(t);
    }
}
