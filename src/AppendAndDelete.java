
import java.util.*;
public class AppendAndDelete {

    static String appendAndDelete(String s, String t, int k) {
        if(s.equals(t)){
            if(k>=2*s.length() || k%2==0){
                return "Yes";
            }
        }
        int firstMismatchIndex = firstMismatch(s,t);
        int nmcInS = s.length() - firstMismatchIndex;
        int nmcInT = t.length() - firstMismatchIndex;

        boolean cond1 = nmcInS + nmcInT == k;
        boolean cond2 = (nmcInS + nmcInT < k && (nmcInS + nmcInT -k)%2==0);
        boolean cond3 = s.length() + t.length() <= k;

        return cond1||cond2||cond3?"Yes":"No";
    }

    static int firstMismatch(String s1,String s2){
        int mismatch = -1;
        for(int i = 0;i<Math.min(s1.length(),s2.length());i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                return i;
            }
        }
        return mismatch;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();
        String result = appendAndDelete(s, t, k);
        System.out.println(result);
        in.close();
    }
}
