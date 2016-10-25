/**
 * Created by belows on 2016/10/24.
 */

class T15 {
    String s ;
    T15(String s) {
        this.s = s;
    }
}

public class Ex15 {
    T15 getInstance() {
        return new T15("sdofjo") {};
    }

    public static void main(String[] args) {
        new Ex15().getInstance();
    }
}
