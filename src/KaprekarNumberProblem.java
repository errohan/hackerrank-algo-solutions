import java.util.Scanner;

/*
  author  : rohan.gupta
  created : 1/2/18
*/
public class KaprekarNumberProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int r2 = sc.nextInt();
        int count=0;
        for(int i = r1;i<=r2;i++){
            if(isKaprekarNumber(i)){
                System.out.print(i + " ");
                count++;
            }
        }
        if(count==0)
            System.out.println("INVALID RANGE");
    }

    private static boolean isKaprekarNumber(int i) {
        long squareOfNumber = i*i;
        String number = "" + squareOfNumber;
        int length = number.length();
        int firstHalf = (int) Math.floor(length/2.0);
        int firstHalfNumber = (firstHalf==0)?0:Integer.parseInt(number.substring(0,firstHalf));
        int secondHalfNumber = Integer.parseInt( number.substring(firstHalf,length));
        if(firstHalfNumber + secondHalfNumber == i){
            return true;
        }
        else {
            return false;
        }
    }


}
