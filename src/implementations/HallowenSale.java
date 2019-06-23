package implementations;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
  author  : rohan1.gupta
  created : 15/7/18
*/
public class HallowenSale {
    // Complete the howManyGames function below.
    static int howManyGames(int initialCost, int decrementCost, int minCost, int sum) {
        int a = initialCost;
        int d = -1 * decrementCost;
        int tn = minCost;
        int n = (tn - a + d) / d;
        int sn = n * (2 * a + (n - 1) * d) / 2;
        int nums = n + (sum - sn) / minCost;
        return nums;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] pdms = scanner.nextLine().split(" ");

        int p = Integer.parseInt(pdms[0]);

        int d = Integer.parseInt(pdms[1]);

        int m = Integer.parseInt(pdms[2]);

        int s = Integer.parseInt(pdms[3]);

        int answer = howManyGames(p, d, m, s);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
        System.out.println(howManyGames(20, 3, 8, 85));
    }
}
