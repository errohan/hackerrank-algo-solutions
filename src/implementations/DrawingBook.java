package implementations;

import java.util.Scanner;

public class DrawingBook {

    static int solve(int n, int p) {
        double fwd = 0;
        double back = 0;
        fwd = Math.ceil((p - 1) / 2.0);
        if (n % 2 == 0) {
            back = Math.ceil((n - p) / 2.0);
        } else {
            back = Math.floor((n - p) / 2.0);
        }
        double d = (fwd <= back) ? fwd : back;
        return (int) (long) d;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int result = solve(n, p);
        System.out.println(result);
    }
}
