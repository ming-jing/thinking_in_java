/**
 * Created by belows on 2016/11/14.
 */
public class ComparablePet
        implements Comparable<ComparablePet> {
    public int compareTo(ComparablePet arg) { return 0; }

    public static void main(String[] args) {

    }
}
class Cat extends ComparablePet{
    // Error: Comparable cannot be inherited with
    // different arguments: <Cat> and <Pet>
    public int compareTo(Cat arg) { return 0; }

    @Override
    @Deprecated
    public int compareTo(ComparablePet arg) {
        throw new RuntimeException();
    }
}
