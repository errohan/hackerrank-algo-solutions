package implementations;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
  author  : rohan.gupta
  created : 2/2/18
*/
public class HappyLadyBugs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {
            int len = sc.nextInt();
            String s = sc.next();
            if (canLadyBugsBeHappy(s, len)) {
                System.out.println("YES");
            } else System.out.println("NO");
        }

    }

    public static boolean canLadyBugsBeHappy(String ladyBugsArrangement, int len) {
        boolean emptySpace = false;
        Map<Character, Integer> ladyBugsCount = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (ladyBugsArrangement.charAt(i) == '_')
                emptySpace = true;
            else if (!ladyBugsCount.containsKey(ladyBugsArrangement.charAt(i))) {
                ladyBugsCount.put(ladyBugsArrangement.charAt(i), 1);
            } else {
                ladyBugsCount.put(ladyBugsArrangement.charAt(i), ladyBugsCount.get(ladyBugsArrangement.charAt(i)) + 1);
            }
        }
        if (!emptySpace) return false;
        if (ladyBugsCount.size() > 0 && ladyBugsCount.values().contains(1)) {
            return false;
        }
        return true;
    }
}
