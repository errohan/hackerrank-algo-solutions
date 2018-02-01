import java.util.Scanner;

/*
  author  : rohan.gupta
  created : 31/1/18
*/
public class TimeInWords {

    private static String numbers[] = {"zero","one","two","three","four","five","six","seven","eight","nine","ten",
            "eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};

    private static String tens[] = {"none","ten","twenty","thirty","forty","fifty","sixty"};

    private static String getSpelling(int number){
        if(number <= 19){
            return numbers[number];
        }
        else {
            if(number%10==0){
                return tens[number/10];
            }
            else {
                return tens[number/10] + " " + numbers[number%10];
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hours = sc.nextInt();
        int minutes = sc.nextInt();
        String time = "";
        if(minutes == 0){
            time = getSpelling(hours) + " o' clock";
        }
        else {
            if(minutes==15){
                time = "quarter past " + getSpelling(hours);
            }
            else if(minutes ==30){
                time = "half past " + getSpelling(hours);
            }
            else if(minutes < 30){
                time = getSpelling(minutes) + ((minutes==1)?" minute ":" minutes ") + "past " + getSpelling(hours);
            }
            else {
                if(hours == 12){
                    hours = 1;
                }
                else hours++;
                if(minutes == 45){
                    time = "quarter to " + getSpelling(hours);
                }
                else
                time = getSpelling(60-minutes) + ((60-minutes==1)?" minute to ":" minutes to ") + getSpelling(hours);
            }
        }
        System.out.println(time);
    }
}
