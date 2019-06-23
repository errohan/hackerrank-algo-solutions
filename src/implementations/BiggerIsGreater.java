package implementations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
  author  : rohan.gupta
  created : 1/2/18
*/
public class BiggerIsGreater {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> result = new ArrayList<>();

        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            String s = sc.next();
            result.add(getNextLexiographicSequence(s));
        }
        result.forEach(r -> {
            System.out.println(r);
        });
    }

    private static String getNextLexiographicSequence(String s) {
        String nextLexiographicSequence;
        int pivotIndex = getPivotIndex(s);
        int ceilIndex;
        if (pivotIndex == -1) {
            nextLexiographicSequence = "no answer";
        } else {
            ceilIndex = getCeilIndex(s, pivotIndex);
            String swappedString = swapChars(s, pivotIndex, ceilIndex);
            nextLexiographicSequence = sortStringAfterIndex(swappedString, pivotIndex);
        }
        return nextLexiographicSequence;
    }

    private static String sortStringAfterIndex(String s, int pivotIndex) {
        String unchangedString = s.substring(0, pivotIndex + 1);
        String toBeSortedString = s.substring(pivotIndex + 1, s.length());
        return unchangedString + sortString(toBeSortedString);
    }

    private static String sortString(String toBeSortedString) {
        char[] charArray = toBeSortedString.toCharArray();
        Arrays.sort(charArray);
        toBeSortedString = new String(charArray);
        return toBeSortedString;
    }

    private static String swapChars(String s, int a, int b) {
        char f = s.charAt(a);
        char g = s.charAt(b);
        StringBuilder modifiedString = new StringBuilder(s);
        modifiedString.setCharAt(a, g);
        modifiedString.setCharAt(b, f);
        return modifiedString.toString();
    }

    private static int getCeilIndex(String s, int pivotIndex) {
        int ceilIndex = pivotIndex + 1;
        char pivotElement = s.charAt(pivotIndex);
        for (int i = pivotIndex + 1; i < s.length(); i++) {
            if ((int) s.charAt(i) > (int) pivotElement && (int) s.charAt(i) <= (int) s.charAt(ceilIndex)) {
                ceilIndex = i;
            }
        }
        return ceilIndex;
    }

    private static int getPivotIndex(String s) {
        int pivotIndex = -1;
        for (int i = 0; i < s.length() - 1; i++) {
            if ((int) s.charAt(i) < (int) s.charAt(i + 1)) {
                pivotIndex = i;
            }
        }
        return pivotIndex;
    }
}
