import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
  author  : rohan.gupta
  created : 7/2/18
*/
public class AbsolutePermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0;i<t;i++){
            int n = sc.nextInt();
            int diff = sc.nextInt();
            computeResult(n,diff);
        }
    }

    private static void computeResult(int n , int diff){
        int i,j;
        if(diff == 0){
            for(i = 1;i<=n;i++){
                System.out.print(i + " ");
            }
        }
        else if(n%2==0 && (n/diff)%2==0 && (n%diff==0) && diff < n){
            int sol[] = new int[n];
            for(i = 1;i<n/diff;i=i+2){
                for(j=(i-1)*diff+1;j<=i*diff;j++){
                    sol[j-1] = j+diff;
                    sol[sol[j-1]-1] = j;
                }
            }
            printSolution(sol);
        }
        else {
            System.out.print(-1);
        }
        System.out.println();
    }

    private static void printSolution(int[] sol) {
        for (int i = 0;i<sol.length;i++){
            System.out.print(sol[i] + " ");
        }
    }
}
