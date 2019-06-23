package hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @author : rohan1.gupta
 * @created: 18/5/19
 */
public class TwoString {
    static String twoStrings(String s1, String s2) {
        boolean s = false;
        char[] a = s1.toCharArray();
        Set<Character> b = new HashSet<>();
        for (char c : s2.toCharArray()) {
            b.add(c);
        }
        Arrays.asList(s2.toCharArray());
        for (char c : a) {
            if(b.contains(c)){
                s=true;
                break;
            }
        }
        return s?"YES":"NO";
    }

    public static void main(String[] args) {
        System.out.println(twoStrings("hello","world"));
    }
}
