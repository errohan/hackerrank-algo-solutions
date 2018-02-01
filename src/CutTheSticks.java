import java.util.*;

public class CutTheSticks {

    static List<Integer> cutTheSticks(Map<Integer,Integer> sticks,int n) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> stickSet = new ArrayList<>(sticks.keySet());
        Collections.sort(stickSet);
        for(int i = 0;i<stickSet.size();i++){
            result.add(n);
            n -= sticks.get(stickSet.get(i));
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer,Integer> sticks = new LinkedHashMap<>();
        for(int arr_i = 0; arr_i < n; arr_i++){
            int stick = in.nextInt();
            if(sticks.containsKey(stick)){
                sticks.put(stick,sticks.get(stick)+1);
            }
            else {
                sticks.put(stick,1);
            }
        }
        cutTheSticks(sticks,n).forEach(l->{
            System.out.println(l);
        });

        in.close();
    }
}
