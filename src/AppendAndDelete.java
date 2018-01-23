
import java.util.*;
public class AppendAndDelete {

    static String appendAndDelete(String s, String t, int k) {
        String s1,s2;
        int effort = 0;
        if(s.length() >= t.length()){
            s1 = s;
            s2 = t;
        }
        else {
            s1=t;
            s2 = s;
        }
        int mismatch = firstMismatch(s1,s2);
        if(mismatch == -1){
            effort = s1.length() -s2.length();
        }
        else {
            effort = s1.length()-mismatch + (s2.length()-mismatch);
        }
        if(effort <= k){
            return "Yes";
        }
        else
            return "No";


    }

    static int firstMismatch(String s1,String s2){
        int mismatch = -1;
        for(int i = 0;i<s2.length();i++){
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
