import java.util.*;

/*
  author  : rohan.gupta
  created : 1/2/18
*/
public class MinimumDistances {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num;
        ArrayList<Integer> dist = new ArrayList<>();
        Map<Integer,Integer> nums = new LinkedHashMap<>();
        for(int i = 0;i<n;i++){
            num = sc.nextInt();
            if(nums.get(num) != null){
                int d = Math.abs(nums.get(num) - i);
                dist.add(d);

            }
            nums.put(num,i);
        }
        Collections.sort(dist);
        System.out.println((dist.size()==0)?-1:dist.get(0));
    }
}