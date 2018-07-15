package implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
  author  : rohan.gupta
  created : 1/2/18
*/
public class BeautifulTriplets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr.add(in.nextInt());
        }
        in.close();
        int paircount = 0;
        for(int i = 0;i<n-2;i++){
            if(arr.contains(arr.get(i) + d) && arr.contains(arr.get(i) + (2*d))){
                paircount++;
            }
        }
        System.out.println(paircount);
    }
}
