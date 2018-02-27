package implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
  author  : rohan.gupta
  created : 30/1/18
*/
public class OrganisingBallContainers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        boolean possiblity[] = new boolean[testCases];
        //Iteration over testcases
        for (int i = 0; i < testCases; i++) {
            int dimension = sc.nextInt();
            //Dimension of each
            long[][] matrix = new long[dimension][dimension];
            //Iteration over row
            for (int row = 0; row < dimension; row++) {
                //iterating over column
                for (int column = 0; column < dimension; column++) {
                    matrix[row][column] = sc.nextLong();
                }
            }

            //Checking possiblity
            possiblity[i] = checkPossiblity(matrix, dimension);
        }
        for (int i = 0; i < testCases; i++) {
            if (possiblity[i]) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }

    public static boolean checkPossiblity(long[][] m, int n) {
        List<Long> row = new ArrayList<>();
        List<Long> col = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long rowsum = 0;
            long colsum = 0;
            for (int j = 0; j < n; j++) {
                rowsum += m[i][j];
                colsum += m[j][i];
            }
            row.add(rowsum);
            col.add(colsum);
        }
        row.removeAll(col);
        if (row.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}