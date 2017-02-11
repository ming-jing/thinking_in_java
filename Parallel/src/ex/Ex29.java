package ex;

/**
 * Created by belows on 2017/2/7.
 */
public class Ex29 {

    enum Status {
        DRY,
        BUTTERED,
        JAMMED,
        READY {
            @Override
            public String toString() {
                return BUTTERED.toString() + " & " + JAMMED.toString();
            }
        }
    }

    static class Toast {
        Status status = Status.DRY;

    }

    static class ToastOMatic {

    }
}
