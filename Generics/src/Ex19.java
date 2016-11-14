import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by belows on 2016/11/10.
 */
public class Ex19 {

    static class Product {
        private static int count = 0;
        public final long id = ++count;

        @Override
        public String toString() {
            return "Product " + id;
        }

        public static Generator<Product> generator = new Generator<Product>() {
            @Override
            public Product next() {
                return new Product();
            }
        };
    }

    static class Container extends ArrayList<Product> {
        public Container(int n) {
            for (int i=0; i<n; ++i) {
                add(Product.generator.next());
            }
        }
    }

    static class CargoHold extends ArrayList<Container> {
        public CargoHold(int nContainer, int nProducts) {
            for (int i=0; i<nContainer; ++i) {
                add(new Container(nProducts));
            }
        }
    }


    public static void main(String[] args) {
        CargoHold hold = new CargoHold(3,5);
        System.out.println(hold);

    }
}
