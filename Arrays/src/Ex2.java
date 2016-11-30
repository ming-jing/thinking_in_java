import java.util.Arrays;

/**
 * Created by belows on 2016/11/17.
 */
public class Ex2 {
    static class BerylliumSphere {
        private static long counter;
        private final long id = counter++;
        public String toString() { return "Sphere " + id; }
    }

    static BerylliumSphere[] test(int n) {
        BerylliumSphere[] berylliumSpheres = new BerylliumSphere[n];
        for (int i=0; i<n; ++i) {
            berylliumSpheres[i] = new BerylliumSphere();
        }

        return berylliumSpheres;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(test(3)));
    }
}
