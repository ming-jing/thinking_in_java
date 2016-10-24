/**
 * Created by belows on 2016/10/19.
 */

interface Tossing {
    void toss();
}

class CoinTossing implements Tossing {
    @Override
    public void toss() {
        System.out.println("Coin Tossing");
    }
}

class DiceTossing implements Tossing {
    @Override
    public void toss() {
        System.out.println("Dice Tossing");
    }
}

interface TossingFactory {
    Tossing create();
}

class CoinFactory implements TossingFactory {
    @Override
    public Tossing create() {
        return new CoinTossing();
    }
}

class DiceFactory implements TossingFactory {
    @Override
    public Tossing create() {
        return new DiceTossing();
    }
}

public class Ex19 {

    static void test(TossingFactory factory) {
        factory.create().toss();
    }

    public static void main(String[] args) {
        test(new CoinFactory());
        test(new DiceFactory());
    }
}
