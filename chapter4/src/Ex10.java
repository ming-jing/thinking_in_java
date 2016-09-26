/**
 * Created by beta on 16-9-26.
 */
public class Ex10 {
    public static void main(String[] args) {
        int s[] = new int[4];
        int r[] = new int[4];

        for (int num1 = 10; num1 < 100; ++num1) {
            for (int num2 = num1; num2 < 100; ++num2) {
                int result = num1 * num2;
                if (result % 9 != (num1 + num2) % 9) {
                    continue;
                }
                s[0] = num1 % 10;
                s[1] = num1 / 10;
                s[2] = num2 % 10;
                s[3] = num2 / 10;
                int k = 1000;
                int b = result;
                for (int i = 0; i < 4; ++i) {
                    r[i] = b / k;
                    b = b % k;
                    k /= 10;
                }

                int count = 0;
                for (int i = 0; i < 4; ++i) {
                    for (int j = 0; j < 4; ++j) {
                        if (r[i] == s[j]) {
                            ++count;
                            r[i] = -1;
                            s[j] = -2;
                        }
                    }
                }
                if (count == 4) {
                    System.out.println(result + "=" + num1 + "*" + num2);
                }
            }
        }
    }
}
/* Output:
15 * 93 : 1395
21 * 60 : 1260
21 * 87 : 1827
27 * 81 : 2187
30 * 51 : 1530
35 * 41 : 1435
80 * 86 : 6880
*///:~
