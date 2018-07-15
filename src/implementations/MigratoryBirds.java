package implementations;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MigratoryBirds {


    static int migratoryBirds(int n, int[] ar) {
        int i;
        int max = 0;
        int maxKey = 0;
        Map<Integer,Integer> m = new HashMap<>();
        for(i=0;i<n;i++){
            if(m.get(ar[i]) == null){
                m.put(ar[i],1);
            }
            else {
                m.put(ar[i],m.get(ar[i])+1);
            }
        }
        for(Map.Entry<Integer,Integer> es : m.entrySet()){
            if(es.getValue() > max){
                max = es.getValue();
                maxKey = es.getKey();
            }
            else if(es.getValue() == max){
                if(es.getKey() < maxKey){
                    max = es.getValue();
                    maxKey = es.getKey();
                }
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);

    }
}
