import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/*
  author  : rohan.gupta
  created : 2/2/18
*/
public class MansaAndStones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for(int i = 0;i<testCases;i++){
            int n = sc.nextInt();
            int d1 = sc.nextInt();
            int d2 = sc.nextInt();
            int a = 0;
            int l;
            if(d2<d1){
                int t = d1;
                d1 = d2;
                d2 = t;
            }
            Set<Integer> lastDigits = new LinkedHashSet<>();
            l = a + (n-1)*d1;
            lastDigits.add(l);
            int diff = d2-d1;
            for(int k = 1;k<n;k++){
                l = l+diff;
                if(!lastDigits.contains(l))
                lastDigits.add(l);

            }
            lastDigits.forEach(ld->{
                System.out.print(ld + " ");
            });
            System.out.println();
        }
    }
}
