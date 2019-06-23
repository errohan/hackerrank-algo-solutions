package implementations;

import java.math.BigInteger;
import java.util.*;

public class ExtraLongFactorials {

    static void extraLongFactorials(int n) {
        BigInteger num = new BigInteger("1");
        for (int i = n; i > 1; i--) {
            num = num.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(num);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        extraLongFactorials(n);
        in.close();
    }
}
