import java.util.*;

public class CutTheSticks {

    static List<Integer> cutTheSticks(List<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<>();
        Collections.sort(arr);
        int count;
        int minIndex = 0;
        int nextIndex = minIndex+1;
        while (minIndex != arr.size()){
            count = arr.size()-minIndex;
            result.add(count);
            while (nextIndex<arr.size() && arr.get(minIndex) == arr.get(nextIndex)){
                nextIndex++;
            }
            minIndex = nextIndex;
            nextIndex = minIndex+1;
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr.add(in.nextInt());
        }
        cutTheSticks(arr).forEach(a->{
            System.out.println(a);
        });
        System.out.println("");


        in.close();
    }
}
