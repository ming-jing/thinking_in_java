/**
 * Created by belows on 2016/11/17.
 */
public class Ex1 {
    static class BerylliumSphere {
        private static long counter;
        private final long id = counter++;
        public String toString() { return "Sphere " + id; }
    }

    public static void test(BerylliumSphere[] berylliumSpheres) {}

    public static void main(String[] args) {
        BerylliumSphere[] berylliumSpheres = {new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()};
        test(berylliumSpheres);

//        test({new BerylliumSphere(),new BerylliumSphere()});
        test(new BerylliumSphere[]{new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()});


    }
}
