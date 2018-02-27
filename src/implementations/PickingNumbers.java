package implementations;

import java.util.*;

public class PickingNumbers {

    static int pickingNumbers(Integer[] a) {
        List<Integer> numList = new ArrayList<Integer>(Arrays.asList(a));
        Collections.sort(numList);
        Map<Integer, Integer> numsCount = new LinkedHashMap<>();
        for (Integer n : numList) {
            if (numsCount.get(n) == null) {
                numsCount.put(n, 1);
            } else {
                numsCount.put(n, numsCount.get(n) + 1);
            }
        }
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> numsCountsList = new ArrayList<>();
        numsCount.entrySet().forEach(n -> {
            nums.add(n.getKey());
            numsCountsList.add(n.getValue());
        });
        int highCount = 0;
        for (int i = 0; i < numsCountsList.size() - 1; i++) {
            if (Math.abs(nums.get(i) - nums.get(i + 1)) == 1) {
                if ((numsCountsList.get(i) + numsCountsList.get(i + 1)) > highCount) {
                    highCount = numsCountsList.get(i) + numsCountsList.get(i + 1);
                }
            }
        }
        Collections.sort(numsCountsList);
        Collections.reverse(numsCountsList);
        if(highCount  < numsCountsList.get(0)){
            highCount = numsCountsList.get(0);
        }
        return highCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] a = new Integer[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        int result = pickingNumbers(a);
        System.out.println(result);
        in.close();
    }
}
