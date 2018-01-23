import java.util.*;

public class EqualizeArray {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer,Integer> arr = new HashMap<>();
        for(int arr_i = 0; arr_i < n; arr_i++){
            int x = in.nextInt();
            if(arr.get(x)==null){
                arr.put(x,1);
            }
            else {
                arr.put(x,arr.get(x)+1);
            }
        }
        int max=0;
        for(Map.Entry<Integer,Integer> m : arr.entrySet()){
            if(max < m.getValue()){
                max = m.getValue();
            }
        }
        System.out.println(n-max);
        in.close();
    }
}
