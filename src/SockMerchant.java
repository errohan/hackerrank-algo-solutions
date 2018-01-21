import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SockMerchant {

    static int sockMerchant(int n, int[] ar) {
        Set<Integer> socks = new HashSet<>();
        int i;
        int count = 0;
        for(i=0;i<n;i++){
            if(socks.size() == 0){
                socks.add(ar[i]);
            }
            else if(socks.contains(ar[i])){
                count++;
                socks.remove(ar[i]);
            }
            else {
                socks.add(ar[i]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }
}
