import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

/**
 * Created by belows on 2016/12/7.
 */
public class Ex28 {
    private static class TwoTuple<A,B> implements Comparable<TwoTuple<A,B>>{
        A first;
        B second;

        @Override
        public int compareTo(@NotNull TwoTuple<A, B> o) {
            int firstCompare = 0;
            if (first!=null) {
                firstCompare = ((Comparable<A>)first).compareTo(o.first);
            }
            return 0;
        }

        TwoTuple(A a, B b) {
            first = a;
            second = b;
        }

        public A getFirst() {
            return first;
        }

        public B getSecond() {
            return second;
        }

        @Override
        public int hashCode() {
            int result = 17;
            if (first !=null) {
                result = 37 * result + first.hashCode();
            }
            if (second != null) {
                result = 37 * result + second.hashCode();
            }
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof TwoTuple) {
                TwoTuple<A,B> other = (TwoTuple<A,B>)obj;
                return (first==null?other.first==null:first.equals(other.first))&&
                        (second==null?other.second==null:second.equals(other.second));
            }
            return false;
        }
    }
}
