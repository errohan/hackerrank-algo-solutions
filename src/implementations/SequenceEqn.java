package implementations;

import java.util.Scanner;

public class SequenceEqn {

    static int[] permutationEquation(int[] p) {
        int result[] = new int[p.length - 1];
        for (int x = 1; x < p.length; x++) {
            for (int j = 1; j < p.length; j++) {
                if (p[p[j]] == x) {
                    result[x - 1] = j;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n + 1];
        for (int p_i = 1; p_i <= n; p_i++) {
            p[p_i] = in.nextInt();
        }
        int[] result = permutationEquation(p);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}