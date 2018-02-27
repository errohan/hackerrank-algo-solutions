package implementations;

import java.util.Scanner;

public class FindDigits {

    static int findDigits(int n) {
        String num = "" + n;
        int count = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) != '0') {
                if (n % Integer.parseInt("0" + num.charAt(i)) == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int result = findDigits(n);
            System.out.println(result);
        }
        in.close();
    }
}
