import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by belows on 2016/11/18.
 */
public class Ex6 {
    static class BerylliumSphere {
        private static long counter;
        private final long id = counter++;
        public String toString() { return "Sphere " + id; }
    }

    public static BerylliumSphere[][] creat(int s1, int s2) {
        BerylliumSphere[][] berylliumSpheres = new BerylliumSphere[s1][s2];

        for (int i=0; i<s1; ++i) {
            for (int j=0; j<s2; ++j ) {
                berylliumSpheres[i][j] = new BerylliumSphere();
            }
        }

        return berylliumSpheres;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner strScanner = new Scanner(line);

            int s1 = strScanner.nextInt();
            int s2 = strScanner.nextInt();

            System.out.println(Arrays.deepToString(creat(s1,s2)));
        }
    }
}
