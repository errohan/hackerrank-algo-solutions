package implementations;

/*
 * @author : rohan1.gupta
 * @created: 14/4/19
 */
public class HallowenSaleII {

    public static int getVediogames(int p, int d, int m, int s) {
        if (s < p) return 0;
        else if (s == p) return 1;
        else {
            int n = 1 + (p - m) / d;
            int sn = n * (2 * p + (n - 1) * (-d)) / 2;
            if (s > sn) {
                int r = s - sn;
                int rv = r / m;
                return rv + n;
            } else {
                int b = 2 * p + d;
                return (int) (b - Math.sqrt(b * b - 8 * d * s)) / (2 * d);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getVediogames(100, 19, 1, 180));
    }
}