import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by belows on 2016/11/18.
 */
public class Ex4 {

    private static Random random = new Random(47);

    public static double[][][] create(int s1,int s2, int s3, double start, double end) {
        double[][][] r = new double[s1][s2][s3];

        for (int i=0; i<s1; ++i) {
            for (int j=0; j<s2; ++j) {
                for (int k=0; k<s3; ++k) {
                    r[i][j][k] = range(start,end);
                }
            }
        }

        return r;
    }

    public static double range(double start, double end) {
        int dis = (int) (end -start);

        double r = random.nextDouble() + random.nextInt(dis) + start;

        return r > end? end : r;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner strScanner = new Scanner(line);
            int s1 = strScanner.nextInt();
            int s2 = strScanner.nextInt();
            int s3 = strScanner.nextInt();
            double start = strScanner.nextDouble();
            double end = strScanner.nextDouble();

            System.out.println(Arrays.deepToString(create(s1,s2,s3,start,end)));
        }

    }
}
