
import java.util.*;
public class AppendAndDelete {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int k = sc.nextInt();

        if(isAppendAndDeletePossible(s,t,k)){
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

    }

    private static boolean isAppendAndDeletePossible(String s, String t, int k) {
        if(s.equals(t)){
            if(k >= s.length()*2 || k%2==0)
                return true;
        }
        else {
            if(k>= s.length() + t.length())
                return true;
            int matchingCharacters = getMatchingCharacters(s,t);
            int effort = s.length()+t.length() - (2*matchingCharacters);
            if(effort <=k && (k-effort)%2==0){
                return true;
            }
        }
        return false;
    }

    private static int getMatchingCharacters(String s, String t) {
        int matchingChars = 0;
        for(int i = 0;i<Math.min(s.length(),t.length());i++){
            if(s.charAt(i) == t.charAt(i)){
                matchingChars++;
            }
            else break;
        }
        return matchingChars;
    }
}
