
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
            /*
            * If both strings are equal then, we actually need even number of operations as we need
            * to delte and insert same elemets
            *
            *
            * Also deletion on empty string results in empty string so in such case performing n deletions
            * will lead to some empty string i.e. deletions = n (where n is length of string)
            *
            * now if we perform x deletions on empty string , it will have no effect, where x>=0
            *
            * now if we again populate string as same string we need n append operations i.e append = n
            *
            * so total operations = n + n + x --> 2n + x , where x>=0
            * so if k >= 2*n OR if k%2 == 0, operation can be performed
            *
            */
            if(k >= s.length()*2 || k%2==0)
                return true;
        }
        else {
            /*
             * Now if the k = length of sum of two strings i.e. n1 + n2 then we can delete one string
             * and generate another string which will hold true
             *
             * Also if k > n1 + n2 then, also we can generate other string as, we can include extra operations
             * as deletion on empty string
             */
            if(k>= s.length() + t.length())
                return true;

            /*
            * Now other case, we need to find the number of effort that we need actually
            * in that case we need to delte non matching characters from s and append to it nonmatching from t
            * i.e. ->effort =  s.length + t.length - 2*nonMatchingChars
            * in case if k > effort then ->
            * if we perform unnecessary deletions then in that case (k - effort) %2 = 0 i.e. even
            */
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
