/**
 * Created by beta on 16-10-1.
 */
public class Ex21 {
    enum PaperCurrency {
        ONE(1, "des 1"), TWO(2, "des 2"), FIVE(5, "des 5"), TEN(10, "des 10"), TWEENTY(20, "des 20");
        int value;
        String des;

        private PaperCurrency(int v, String des) {
            value = v;
            this.des = des;
        }
    }

    public static void main(String[] args) {
        for (PaperCurrency paperCurrency : PaperCurrency.values()) {
//            System.out.println(paperCurrency.name() + " " + paperCurrency.value + " " + paperCurrency.des);
            switch (paperCurrency) {
                case ONE:
                    System.out.println("Case One");
                    break;
                case TWO:
                    System.out.println("Case Two");
                    break;
                case FIVE:
                    System.out.println("Case Five");
                    break;
                case TEN:
                    System.out.println("Case Ten");
                    break;
                case TWEENTY:
                    System.out.println("Case Tweenty");
                    break;
            }
        }

    }
}
