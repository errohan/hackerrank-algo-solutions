package implementations;

import java.util.Scanner;

public class ThunderCloud {

    static int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        int start = -1;
        while (start!= 0){
            if(start == -1)
                start = 0;
            start = (start + k)%c.length;
            if(c[start] == 1){
                energy = energy-2;
            }
            energy--;
        }
        return energy;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] c = new int[n];
        for(int c_i = 0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int result = jumpingOnClouds(c, k);
        System.out.println(result);
        in.close();
    }
}
