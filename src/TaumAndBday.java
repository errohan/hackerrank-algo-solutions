import java.math.BigInteger;
import java.util.Scanner;

/*
  author  : rohan.gupta
  created : 24/1/18
*/
public class TaumAndBday {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();
        BigInteger result[] = new BigInteger[numberOfTestCases];
        for(int i = 0;i<numberOfTestCases;i++){
            int b = sc.nextInt();
            int w = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            result[i] = compute(b,w,x,y,z);
        }
        for (BigInteger i : result) {
            System.out.println(i);
        }
        sc.close();
    }

    private static BigInteger compute(int b, int w, int x, int y, int z) {
        int bPrice = x;
        int wPrice = y;
        if(x>y+z){
            bPrice = y+z;
        }
        if(y>x+z){
            wPrice = x+z;
        }
        return (new BigInteger(String.valueOf(b)).multiply(new BigInteger(String.valueOf(bPrice))).add((new BigInteger(String.valueOf(w)).multiply(new BigInteger(String.valueOf(wPrice))))));
    }
}
