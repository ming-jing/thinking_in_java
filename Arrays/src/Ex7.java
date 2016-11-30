import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by belows on 2016/11/18.
 */
public class Ex7 {
    static class BerylliumSphere {
        private static long counter;
        private final long id = counter++;
        public String toString() { return "Sphere " + id; }
    }

    public static BerylliumSphere[][][] create(int s1, int s2, int s3) {
        BerylliumSphere[][][] berylliumSpheres = new BerylliumSphere[s1][s2][s3];

        for (int i=0; i<s1; ++i) {
            for (int j=0; j<s2; ++j) {
                for (int k=0; k<s3; ++k) {
                    berylliumSpheres[i][j][k] = new BerylliumSphere();
                }
            }
        }

        return berylliumSpheres;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            Scanner scanner = new Scanner(line);

            int s1 = scanner.nextInt();
            int s2 = scanner.nextInt();
            int s3 = scanner.nextInt();

            System.out.println(Arrays.deepToString(create(s1,s2,s3)));
        }

    }
}
