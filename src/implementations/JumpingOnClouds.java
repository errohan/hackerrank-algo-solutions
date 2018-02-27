package implementations;

import java.util.*;

public class JumpingOnClouds {

    static int jumpingOnClouds(int[] c) {
        int steps = 0;
        for(int i = 0;i<c.length-1;){
            if(i+2 < c.length && c[i+2] == 0){
                i =  i+2;
            }
            else i++;

            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] c = new int[n];
        for(int c_i = 0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int result = jumpingOnClouds(c);
        System.out.println(result);
        in.close();
    }
}
