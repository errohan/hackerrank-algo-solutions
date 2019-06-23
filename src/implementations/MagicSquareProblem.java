package implementations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MagicSquareProblem {

    static int formingMagicSquare(int[][] s) {
        // Complete this function
        int n = 0;
        return n;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Set<Integer> nums = new HashSet<Integer>(Arrays.asList(a));
        Set<Integer> extra = new HashSet<>();
        int[][] s = new int[3][3];
        for (int s_i = 0; s_i < 3; s_i++) {
            for (int s_j = 0; s_j < 3; s_j++) {
                s[s_i][s_j] = in.nextInt();
                if (nums.contains(s[s_i][s_j])) {
                    nums.remove(s[s_i][s_j]);
                } else {
                    extra.add(s[s_i][s_j]);
                }
            }
        }
        int result = formingMagicSquare(s);
        System.out.println(result);
        in.close();
    }
}
