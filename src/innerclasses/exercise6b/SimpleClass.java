package innerclasses.exercise6b;

/**
 * Created by beta on 16-10-19.
 */

import innerclasses.exercise6.SimpleInterface;

public class SimpleClass {
    protected class Inner implements SimpleInterface {
        // Force constructor to be public:
        public Inner() {
        }

        public void f() {
        }
    }
}
