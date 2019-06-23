package implementations;

import java.util.*;

public class RepeatedString {

    static long repeatedString(String s, long n) {
        long completeOccurence = n / s.length();
        int partialOccurence = (int) (n % s.length());
        Counter c = countOccurence(s, partialOccurence);
        return (completeOccurence * c.completeCount) + (c.partialCount);
    }

    static Counter countOccurence(String s, int partialLength) {
        Counter c = new Counter();
        long count = 0l;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                count++;
            }
            if (i == partialLength - 1) {
                c.partialCount = count;
            }
        }
        c.completeCount = count;
        return c;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        long result = repeatedString(s, n);
        System.out.println(result);
        in.close();
    }
}

class Counter {
    long completeCount;
    long partialCount;
}
