package implementations;

import java.util.*;

public class ClimbingLeaderBoard {

    static int[] climbingLeaderboard(int scores[], int[] alice) {
        int aliceRank[] = new int[alice.length];
        int rank;
        for (int i = 0;i<alice.length;i++) {
            rank = bsearch(scores,alice[i]);
            if(scores[rank] == alice[i]){
                aliceRank[i] = rank+1;
            }
            else if(scores[rank] > alice[i]){
                aliceRank[i] = rank+2;
            }
            else {
                aliceRank[i] = rank+1;
            }
        }
        return aliceRank;
    }

    public static int bsearch(int a[] , int n){
        int low = 0 , high = a.length-1;
        int mid = -1;
        while(low < high){
            mid = (low + high)/2;
            if(a[mid] > n){
                low = mid + 1;
            }
            else if(a[mid] < n){
                high = mid -1;
            }
            else {
                return mid;
            }
        }
        return low;
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Set<Integer> scoreSet = new LinkedHashSet<>();
        for(int scores_i = 0; scores_i < n; scores_i++){
            scoreSet.add(in.nextInt());
        }
        int []scores = new int[scoreSet.size()];
        int c = 0;
        for(int s : scoreSet){
            scores[c] = s;
            c++;
        }
        int m = in.nextInt();
        int[] alice = new int[m];
        for(int alice_i = 0; alice_i < m; alice_i++){
            alice[alice_i] = in.nextInt();
        }
        int[] result = climbingLeaderboard(scores, alice);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}