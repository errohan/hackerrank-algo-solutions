package implementations;

/*
 * @author : rohan1.gupta
 * @created: 13/4/19
 */
public class KarpeskarNumberProblemII {
    public static boolean isKarpeskarNumber(int n){
        long sqr = (long) n*n;
        int actLen = Integer.toString(n).length();
        String sqrtoString = Long.toString(sqr);
        int sqrLen = sqrtoString.length();
        int firstHalf=0 , secondHalf=0;
        int flen=sqrLen/2;
        secondHalf = (Integer.parseInt(sqrtoString.substring(flen)));
        if(actLen<sqrLen)
            firstHalf = (Integer.parseInt(sqrtoString.substring(0,flen)));
        if(!(sqrLen>actLen) || secondHalf>0){
            return firstHalf+secondHalf==n;
        }else return false;
    }

    public static void main(String[] args) {
        int start = 1,end = 99999;
        System.out.println(isKarpeskarNumber(77778));
        /*for(int i = start;i<=end;i++){
            if(isKarpeskarNumber(i)){
                System.out.println(i);
            }
        }*/
    }
}
//1 9 45 55 99 297 703 999 2223 2728 4950 5050 7272 7777 9999 17344 22222 77778 82656 95121 99999