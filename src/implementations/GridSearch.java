package implementations;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
  author  : rohan.gupta
  created : 2/2/18
*/
public class GridSearch {

    public static Set<Integer> getSubstringIndexes(String str, String substr) {
        Set<Integer> s = new HashSet<>();
        int index = str.indexOf(substr);
        while (index >= 0) {
            s.add(index);
            index = str.indexOf(substr, index + 1);
        }
        return s;
    }

    public static boolean doesGridContainsPattern(String[] grid, String[] pattern, int gridSize, int patternSize) {
        for (int gridRow = 0; gridRow < gridSize - patternSize; gridRow++) {
            int patternIndex = 0;
            Set<Integer> startIndexesOfSubPatterns = new HashSet<>();
            if (grid[gridRow].contains(pattern[patternIndex])) {
                startIndexesOfSubPatterns.addAll(getSubstringIndexes(grid[gridRow], pattern[patternIndex]));
                patternIndex++;
                for (int i = patternIndex; i < patternSize && startIndexesOfSubPatterns.size() > 0; i++) {
                    startIndexesOfSubPatterns.retainAll(getSubstringIndexes(grid[gridRow + i], pattern[i]));
                }
                if (startIndexesOfSubPatterns.size() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        for (int i = 0; i < testCases; i++) {
            int gridRow = sc.nextInt();
            int gridCol = sc.nextInt();
            String grid[] = new String[gridRow];
            for (int gridInput = 0; gridInput < gridRow; gridInput++) {
                grid[gridInput] = sc.next();
            }
            int patternRow = sc.nextInt();
            int patternCol = sc.nextInt();
            String pattern[] = new String[patternRow];
            for (int patternInput = 0; patternInput < patternRow; patternInput++) {
                pattern[patternInput] = sc.next();
            }
            if (doesGridContainsPattern(grid, pattern, gridRow, patternRow)) {
                System.out.println("YES");
            } else System.out.println("NO");
        }
    }
}
