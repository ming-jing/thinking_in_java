/**
 * Created by belows on 2016/10/24.
 */

interface Tossing {
    void toss();
}

interface TossingFactory {
    Tossing create();
}

class CoinTossing implements Tossing {
    @Override
    public void toss() {
        System.out.println("Coin Tossing");
    }

    public static TossingFactory factory = new TossingFactory() {

        class Test {};

        @Override
        public Tossing create() {
            return new CoinTossing();
        }
    };
}

class DiceTossing implements Tossing {
    @Override
    public void toss() {
        System.out.println("Dice Tossing");
    }

    public static TossingFactory factory = new TossingFactory() {
        @Override
        public Tossing create() {
            return new DiceTossing();
        }
    };
}



public class Ex17 {

    public static void toss(TossingFactory factory) {
        factory.create().toss();
    }

    public static void main(String[] args) {
        toss(CoinTossing.factory);
        toss(DiceTossing.factory);
    }
}
